package beerbear.caldasturistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText eRuser, eRpass, eRpassConf, eMail;
    Button bRlog, bRcancel;

    String user,pass,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        eRuser = (EditText) findViewById(R.id.eRuser);
        eRpass = (EditText) findViewById(R.id.eRpass);
        eRpassConf = (EditText) findViewById(R.id.eRpassConf);
        eMail = (EditText) findViewById(R.id.eMail);
        bRlog = (Button) findViewById(R.id.bRlog);
        bRcancel= (Button) findViewById(R.id.bRcancel);

        bRlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (eRuser.getText().toString().equals("") || eRpass.getText().toString().equals("") || eRpassConf.getText().toString().equals("") || eMail.getText().toString().equals("")){
                    Toast.makeText(RegisterActivity.this,"Debe llenar todos los campos",Toast.LENGTH_SHORT).show();
                }else if (!eRpass.getText().toString().equals(eRpassConf.getText().toString()) ){
                    Toast.makeText(RegisterActivity.this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent();
                    intent.putExtra("username", eRuser.getText().toString());
                    intent.putExtra("passwrd", eRpass.getText().toString());
                    intent.putExtra("mail", eMail.getText().toString());
                    setResult(RESULT_OK, intent); //responde al que lo llamo sea quien sea
                    finish();
                }
            }
        });

        bRcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterActivity.this, LoginActivity.class);
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}
