package beerbear.caldasturistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    String user,mail;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        user = extras.getString("username");
        mail = extras.getString("mail");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.mPerfil:
                intent =new Intent(MainActivity.this, PerfilActivity.class);
                intent.putExtra("username",user);
                intent.putExtra("mail",mail);
                startActivity(intent);
                break;
            case R.id.mLogOut:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;

        }
        return true;
    }
}
