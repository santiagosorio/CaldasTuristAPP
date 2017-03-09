package beerbear.caldasturistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    TextView tUsername, tMail;
    Intent intent;
    String user, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername = (TextView) findViewById(R.id.tUsename);
        tMail = (TextView) findViewById(R.id.tMail) ;

        Bundle extras=getIntent().getExtras();
        tUsername.setText(extras.getString("username"));
        user = extras.getString("username");
        tMail.setText(extras.getString("mail"));
        mail = extras.getString("mail");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.mPpal:

                intent = new Intent(PerfilActivity.this, MainActivity.class);
                intent.putExtra("username",user);
                intent.putExtra("mail",mail);
                startActivity(intent);
                finish();
                break;
            case R.id.mLogOut:
                intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }
}

