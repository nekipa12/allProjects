package bikeconfigurator.shag.edu.bikeconfigurator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    public static final int KEY_MAIN = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("shag.edu.bikeconfigurator.PartsActivity");
                startActivityForResult(intent, KEY_MAIN);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == KEY_MAIN) {
            if (resultCode == PartsActivity.RESULT_OK) {
                Toast.makeText(getBaseContext(), data.getStringExtra(PartsActivity.KEY_OK), Toast.LENGTH_LONG).show();
            }
        }
    }
}
