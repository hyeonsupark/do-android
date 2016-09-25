package ee.soh.helloandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetNicknameActivity extends AppCompatActivity {

    private EditText etNickname;
    private Button btnSave;
    
    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_nickname);
        
        etNickname = (EditText) findViewById(R.id.et_nickname);
        btnSave = (Button) findViewById(R.id.btn_save_nickname);
        
        preferences = getSharedPreferences("Preference", MODE_PRIVATE);
        preferencesEditor = preferences.edit();

        if(!preferences.getString("nickname", "").equals("")) {
            startActivity(new Intent(SetNicknameActivity.this, MainActivity.class));
            finish();
        }
        
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nickname = etNickname.getText().toString();
                
                preferencesEditor.putString("nickname", nickname.trim());
                if(preferencesEditor.commit()) {

                    Toast.makeText(SetNicknameActivity.this, "Save", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SetNicknameActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(SetNicknameActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
