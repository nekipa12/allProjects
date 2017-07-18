package bikeconfigurator.shag.edu.bikeconfigurator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class WheelsActivity extends AppCompatActivity {

    private ListView lv;
    private Button btn;
    private String [] names;
    public static final String KEY_WHEELS = "7";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheels);
        lv = (ListView) findViewById(R.id.lv);
        btn = (Button) findViewById(R.id.btnWheelsOk);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        names = getResources().getStringArray(R.array.assortiment);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.assortiment, android.R.layout.simple_list_item_single_choice);
        lv.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray arr = lv.getCheckedItemPositions();//получаем выбранные позиции и возвращаем массив этих позиций!
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(arr.keyAt(i))) {
                        Intent intent = getIntent();
                        intent.putExtra(KEY_WHEELS, names[arr.keyAt(i)]);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            }
        });
    }
}
