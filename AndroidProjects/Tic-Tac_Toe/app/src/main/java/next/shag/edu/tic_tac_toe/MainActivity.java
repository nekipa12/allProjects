package next.shag.edu.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private RadioButton rb_3x3, rb_5x5;
    private Button btnPlay;
    private Intent i;
    public static final String KEY = "ff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb_3x3 = (RadioButton) findViewById(R.id.rb_3x3);
        rb_5x5 = (RadioButton) findViewById(R.id.rb_5x5);

        btnPlay = (Button) findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb_3x3.isChecked()) {
                    i = new Intent("android.intent.action.smallSize");
                    i.putExtra(KEY, true);
                    startActivity(i);
                } else {
                    i = new Intent("android.intent.action.smallSize");
                    i.putExtra(KEY, false);
                    startActivity(i);
                }
            }
        });
    }
}
