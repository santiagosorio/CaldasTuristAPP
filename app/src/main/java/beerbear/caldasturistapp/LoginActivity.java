package beerbear.caldasturistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText ePass, eUser;
    Button bLog;
    TextView tRegister;
    String user, pass, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUser = (EditText) findViewById(R.id.eUser);
        ePass = (EditText) findViewById(R.id.ePass);
        bLog = (Button) findViewById(R.id.bLog);
        tRegister = (TextView) findViewById(R.id.tRegister);

        Bundle extras = getIntent().getExtras();
        //en un solo sentido
        /*extras.getString("username");
        Toast.makeText(this, extras.getString("username"),Toast.LENGTH_SHORT).show();*/


        tRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);*/
                Intent intent= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent,1234);


            }
        });
        bLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eUser.getText().toString().equals(user) && ePass.getText().toString().equals(pass)){

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username",user);
                    intent.putExtra("mail", mail);
                    startActivity(intent);

                }else
                    Toast.makeText(LoginActivity.this,"Usuario o contraseña incorrecta",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1234 && resultCode==RESULT_OK){
            user = data.getExtras().getString("username");
            pass =data.getExtras().getString("passwrd");
            mail= data.getExtras().getString("mail");
            Toast.makeText(LoginActivity.this,"Registro Satisfactorio",Toast.LENGTH_SHORT).show();

        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Error en el login",Toast.LENGTH_SHORT).show();
        }
    }
}
