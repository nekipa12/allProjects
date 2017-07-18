package com.example.listgrid;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private GridView gv;
	private ListView lv;
	private Button btn;
	private String[] names;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.btn);
		lv = (ListView) findViewById(R.id.lv);
		gv = (GridView) findViewById(R.id.gv);
		names = getResources().getStringArray(R.array.MyStringArray);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SparseBooleanArray arr = lv.getCheckedItemPositions();//получаем выбранные позиции и возвращаем массив этих позиций!
				for (int i = 0; i < arr.size(); i++) {
					if (arr.get(arr.keyAt(i))) {
						Toast.makeText(getBaseContext(), names[arr.keyAt(i)], Toast.LENGTH_LONG).show();
					}
				}
			}
		});
		ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, names);//simple_list_item_multiple_choice это для множественного выбора!!!
		/*ArrayAdapter<CharSequence> aa2 = ArrayAdapter.createFromResource(this, R.array.MyStringArray, android.R.layout.simple_list_item_single_choice);*/
		//адаптер берёт модель напрямую из ресурса
		lv.setAdapter(aa);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);//этой константой мы разрешаем множественый выбор!
		
		ArrayAdapter<String> adGrid = new  ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
		gv.setAdapter(adGrid);
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getBaseContext(), names[position], Toast.LENGTH_LONG).show();
				
			}
		});
		
	}
}
