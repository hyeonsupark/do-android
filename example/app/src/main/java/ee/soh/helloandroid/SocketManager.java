package ee.soh.helloandroid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by hyeonsu on 2016. 9. 30..
 */
public class SocketManager {
    private Context context;
    private Socket socket;

    private String nickname;

    private Listener messageListener;
    public SocketManager() {

    }

    public SocketManager(Context context, String nickname) {
        try {
            socket = IO.socket("http://ztz.kr:3333");
        } catch (URISyntaxException e) {
            e.printStackTrace();

        }
        socket.connect();

        this.context = context;
        this.nickname = nickname;

    }

    public void disconnect() {
        if(socket != null && socket.connected()) {
            socket.disconnect();
        }
    }

    public void sendMessage(String message) {
        JSONObject chatObject = new JSONObject();
        try {
            chatObject.put("nickname", nickname);
            chatObject.put("message", message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        socket.emit("send message", chatObject);


    }

    interface Listener {
        void receive(JSONObject object);
    }

    public void setMessageListener(Listener listener) {
        messageListener = listener;
        socket.on("receive message", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                final JSONObject chatObject = (JSONObject) args[0];
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        messageListener.receive(chatObject);
                    }
                });
            }
        });
    }

}

