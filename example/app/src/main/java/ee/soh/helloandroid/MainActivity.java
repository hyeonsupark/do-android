package ee.soh.helloandroid;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {

    private ListView lvChat;
    private Button btnSend;
    private EditText etMessage;

    private ChatAdapter chatAdapter;
    private ArrayList<ChatNode> chatNodes;

    private SharedPreferences preferences;

    private Socket socket;

    private String nickname = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            socket = IO.socket("http://ztz.kr:3333");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.connect();

        lvChat = (ListView) findViewById(R.id.lv_chat);
        btnSend = (Button) findViewById(R.id.btn_send);
        etMessage = (EditText) findViewById(R.id.et_message);

        chatNodes = new ArrayList<>();

        chatAdapter = new ChatAdapter(getApplicationContext(), R.layout.row_chat, chatNodes);
        lvChat.setAdapter(chatAdapter);

        preferences = getSharedPreferences("Preference", MODE_PRIVATE);

        nickname = preferences.getString("nickname", "Not Found");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etMessage.getText().toString();
                etMessage.setText("");

                JSONObject chatObject = new JSONObject();
                try {
                    chatObject.put("nickname", nickname);
                    chatObject.put("message", message.trim());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                socket.emit("send message", chatObject);

            }
        });

        final SimpleDateFormat dateFormet = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        socket.on("receive message", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                final JSONObject chatObject = (JSONObject) args[0];
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ChatNode chatNode = new ChatNode();
                        try {
                            chatNode.setNickname(chatObject.getString("nickname"));
                            chatNode.setMessage(chatObject.getString("message"));
                            chatNode.setNicknameColor(chatObject.getString("color"));

                            long timestamp = chatObject.getLong("timestamp") * 1000;
                            chatNode.setTimestamp(dateFormet.format(timestamp));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        chatAdapter.add(chatNode);
                    }
                });


            }
        });
    }
}
