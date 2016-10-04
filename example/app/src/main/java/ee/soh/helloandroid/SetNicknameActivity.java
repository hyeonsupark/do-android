package ee.soh.helloandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetNicknameActivity extends AppCompatActivity {

    private EditText etNickname;
    private Button btnSave;

    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    private Intent fromIntent;

    private boolean isFromMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_nickname);

        etNickname = (EditText) findViewById(R.id.et_nickname);
        btnSave = (Button) findViewById(R.id.btn_save_nickname);

        preferences = getSharedPreferences("Preference", MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        fromIntent = getIntent();
        isFromMain = fromIntent.getBooleanExtra("isFromMain", false);
        boolean isNicknameNull = preferences.getString("nickname", "").equals("");

        if (!isFromMain && !isNicknameNull) {
            startActivity(new Intent(SetNicknameActivity.this, MainActivity.class));
            finish();
        }


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nickname = etNickname.getText().toString();

                preferencesEditor.putString("nickname", nickname.trim());
                if (preferencesEditor.commit()) {

                    if (isFromMain) {
                        Intent intent = getIntent();
                        intent.putExtra("nickname", nickname);
                        setResult(200, intent);

                    } else {
                        startActivity(new Intent(SetNicknameActivity.this, MainActivity.class));
                        setResult(400);
                    }
                    Toast.makeText(SetNicknameActivity.this, "Save", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(SetNicknameActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
