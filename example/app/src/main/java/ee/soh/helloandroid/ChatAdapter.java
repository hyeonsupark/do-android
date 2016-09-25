package ee.soh.helloandroid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hyeonsu on 2016. 9. 25..
 */
public class ChatAdapter extends ArrayAdapter<ChatNode> {

    private Context context;
    private int resource;
    private ArrayList<ChatNode> chatNodes;

    private LayoutInflater inflater;

    private TextView tvNickname;
    private TextView tvMessage;
    private TextView tvTimestamp;

    public ChatAdapter(Context context, int resource, ArrayList<ChatNode> chatNodes) {
        super(context, resource, chatNodes);

        this.context = context;
        this.resource = resource;
        this.chatNodes = chatNodes;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ChatNode chatNode = chatNodes.get(position);
        if(convertView == null) {
            convertView = inflater.inflate(resource, parent, false);

        }

        tvNickname = (TextView) convertView.findViewById(R.id.chat_tv_nickname);
        tvMessage = (TextView) convertView.findViewById(R.id.chat_tv_message);
        tvTimestamp = (TextView) convertView.findViewById(R.id.chat_tv_timstamp);

        tvNickname.setText(chatNode.getNickname());
        tvMessage.setText(": " + chatNode.getMessage());
        tvTimestamp.setText(chatNode.getTimestamp());

        tvNickname.setTextColor(Color.parseColor(chatNode.getNicknameColor()));
        return convertView;
    }
}
