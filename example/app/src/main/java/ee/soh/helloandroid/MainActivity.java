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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {

    private ListView lvChat;
    private Button btnSend;
    private EditText etMessage;

    private ChatAdapter chatAdapter;
    private ArrayList<ChatNode> chatNodes;

    private SharedPreferences preferences;

    private Socket socket;
    private Chat chat;

    private String nickname = "";
    private SimpleDateFormat dateFormet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvChat = (ListView) findViewById(R.id.lv_chat);
        btnSend = (Button) findViewById(R.id.btn_send);
        etMessage = (EditText) findViewById(R.id.et_message);

        chatNodes = new ArrayList<>();

        chatAdapter = new ChatAdapter(getApplicationContext(), R.layout.row_chat, chatNodes);
        lvChat.setAdapter(chatAdapter);

        preferences = getSharedPreferences("Preference", MODE_PRIVATE);

        nickname = preferences.getString("nickname", "Not Found");
        chat = new Chat(this, nickname);

        dateFormet = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etMessage.getText().toString();
                etMessage.setText("");

                chat.sendMessage(message);

            }
        });

        chat.setMessageListener(new Chat.Listener() {
            @Override
            public void receive(String nickname, String message, String nicknameColor, long timestamp) {
                ChatNode chatNode = new ChatNode();
                chatNode.setNickname(nickname);
                chatNode.setMessage(message);
                chatNode.setNicknameColor(nicknameColor);

                chatNode.setTimestamp(dateFormet.format(timestamp));
                chatAdapter.add(chatNode);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        chat.disconnect();

    }
}
