package bikeconfigurator.shag.edu.bikeconfigurator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PartsActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvWh, tvBr, tvCol, tvWheels, tvColor, tvBreak;
    private Button btnBuy;
    public static final int KEY_COLOR = 5;
    public static final int KEY_WHEELS = 6;
    public static final int KEY_BREAK = 7;
    public static final String KEY_OK = "f";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);
        tvWh = (TextView) findViewById(R.id.tvWh);
        tvBr = (TextView) findViewById(R.id.tvBr);
        tvCol = (TextView) findViewById(R.id.tvCol);
        tvWheels = (TextView) findViewById(R.id.tvWheels);
        tvColor = (TextView) findViewById(R.id.tvColor);
        tvBreak = (TextView) findViewById(R.id.tvBreak);
        btnBuy = (Button) findViewById(R.id.btnBuy);
        tvWh.setOnClickListener(this);
        tvBr.setOnClickListener(this);
        tvCol.setOnClickListener(this);
        btnBuy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBuy :
                if (tvColor.getText().toString().equals("") || tvBreak.getText().toString().equals("") || tvWheels.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.msg2, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = getIntent();
                    intent.putExtra(KEY_OK, /*R.string.msgFinal*/"You bought a bicycle");
                    setResult(RESULT_OK, intent);
                    finish();
                }

                break;
            case R.id.tvBr :
                Intent intentBreak = new Intent("shag.edu.bikeconfigurator.BreakActivity");
                startActivityForResult(intentBreak, KEY_BREAK);
                break;
            case R.id.tvCol :
                Intent intentColor = new Intent("shag.edu.bikeconfigurator.ColorActivity");
                startActivityForResult(intentColor, KEY_COLOR);
                break;
            case R.id.tvWh :
                Intent intentWheels = new Intent("shag.edu.bikeconfigurator.WheelsActivity");
                startActivityForResult(intentWheels, KEY_WHEELS);

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == KEY_COLOR) {
            if (resultCode == ColorActivity.RESULT_OK) {
                String fd = data.getStringExtra(ColorActivity.KEY1);
                String [] colors = fd.split(" ");
                tvColor.setBackgroundColor(Color.rgb(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2])));
                tvColor.setText(" ");
            }
        } else if (requestCode == KEY_WHEELS) {
            if(resultCode == WheelsActivity.RESULT_OK) {
                tvWheels.setText(data.getStringExtra(WheelsActivity.KEY_WHEELS));
            }
        } else if (requestCode == KEY_BREAK) {
            if(resultCode == BreakActivity.RESULT_OK) {
                tvBreak.setText(data.getStringExtra(BreakActivity.KEY_BREAK));
            }
        }
    }
}
