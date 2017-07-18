package bikeconfigurator.shag.edu.bikeconfigurator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class BreakActivity extends AppCompatActivity {
    private GridView gv;
    private String [] names;
    public static final String KEY_BREAK = "alb";
    private String result;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break);
        gv = (GridView) findViewById(R.id.gv);
        btn = (Button) findViewById(R.id.btnOkBreak);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!result.equals(null)) {
                        Intent intent = getIntent();
                        intent.putExtra(KEY_BREAK, result);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), R.string.msg, Toast.LENGTH_SHORT).show();
                }

            }
        });
        names = getResources().getStringArray(R.array.assortimentBreak);
        ArrayAdapter <String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, names);
        gv.setAdapter(arrayAdapter);
        gv.setColumnWidth(80);
        gv.setVerticalSpacing(5);
        gv.setHorizontalSpacing(5);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                result = names[position];
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
