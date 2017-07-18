package widget.shag.edu.questionnaire;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabHost th;
    private TabHost.TabSpec ts;
    private ListView lv;
    private String [] positions;
    private TextView tv22, tv21, tv20, tv19, tv18, tv17, tv16, tv15, tv14, tv13, tv12, tv11, tv10, tv9, tv8, tv7, tv6, tv5, tv4, tv3, tv2, tv1;
    private EditText et1GivenNames, et1, etPlace, etPersonalNo, etAuthority, etSeries, etNumber;
    private Spinner sp, spPlace;
    private String [] nationality;
    private int pos, posPlace;
    private RadioGroup rgSex;
    private RadioButton rbSexM, rbSexW;
    private String sex;
    private String[] place;
    private LinearLayout ll;
    private ArrayList<TextView> tv;
    public static final String KEY = "key";
    private String allInfo = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        th = (TabHost) findViewById(R.id.th);
        th.setup();
        ts = th.newTabSpec("tab1");
        ts.setIndicator("questionnaire");
        ts.setContent(R.id.tab1);
        th.addTab(ts);
        ts = th.newTabSpec("tab2");
        ts.setContent(R.id.tab2);
        ts.setIndicator("Result");
        th.addTab(ts);
        tvFind();
        positions = getResources().getStringArray(R.array.positions);
        tvNames();
        tvAddInArrayList();
        lv = (ListView) findViewById(R.id.lv);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.positions, android.R.layout.simple_list_item_1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                switch (position) {
                    case 0 :
                        LayoutInflater ltInflater = getLayoutInflater();
                        final View viewV = ltInflater.inflate(R.layout.layout, null, false);
                        et1 = (EditText) viewV.getRootView().findViewById(R.id.et);
                        final AlertDialog.Builder adbSurname = new AlertDialog.Builder(MainActivity.this);
                        adbSurname.setTitle(R.string.surname_title);
                        adbSurname.setMessage(R.string.surname_msg);
                        adbSurname.setView(viewV);
                        adbSurname.setCancelable(false);
                        if (!tv21.getText().toString().equals("")) {
                            et1.setText(tv21.getText());
                        }
                        adbSurname.setNegativeButton(R.string.surname_btn_cencel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        adbSurname.setPositiveButton(R.string.surname_btn_set, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tv21.setText(et1.getText());
                                view.setBackgroundColor(Color.rgb(0,25,25));
                            }
                        });
                        AlertDialog alert = adbSurname.create();
                        alert.show();
                        break;
                    case 1 :
                        LayoutInflater ltInflaterGivenNames = getLayoutInflater();
                        final View viewGivenNames = ltInflaterGivenNames.inflate(R.layout.layout_given_names, null, false);
                       // ActionBar.LayoutParams lpGivenNames = (ActionBar.LayoutParams) viewGivenNames.getLayoutParams();
                        et1GivenNames = (EditText) viewGivenNames.getRootView().findViewById(R.id.et_given_names);
                        final AlertDialog.Builder adbGivenNames = new AlertDialog.Builder(MainActivity.this);
                        adbGivenNames.setTitle(R.string.given_names_title);
                        adbGivenNames.setMessage(R.string.given_names_msg);
                        adbGivenNames.setView(viewGivenNames);
                        adbGivenNames.setCancelable(false);
                        if (!tv19.getText().toString().equals("")) {
                            et1GivenNames.setText(tv19.getText());
                        }
                        adbGivenNames.setNegativeButton(R.string.surname_btn_cencel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        adbGivenNames.setPositiveButton(R.string.surname_btn_set, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tv19.setText(et1GivenNames.getText());
                                view.setBackgroundColor(Color.rgb(0,25,25));
                            }
                        });
                        AlertDialog alertGivenNames = adbGivenNames.create();
                        alertGivenNames.show();
                        break;
                    case 2 :
                        LayoutInflater ltInflaterNationality = getLayoutInflater();
                        final View viewNationality = ltInflaterNationality.inflate(R.layout.layout_nationality, null, false);
                        //ActionBar.LayoutParams lpNationality = (ActionBar.LayoutParams) viewNationality.getLayoutParams();
                        sp = (Spinner) viewNationality.getRootView().findViewById(R.id.spNationality);
                        nationality = getResources().getStringArray(R.array.nationality);
                        ArrayAdapter<CharSequence> aa2 = ArrayAdapter.createFromResource(getBaseContext(), R.array.nationality, android.R.layout.simple_list_item_1);
                        sp.setAdapter(aa2);
                        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                pos = position;
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        final AlertDialog.Builder adbNationality = new AlertDialog.Builder(MainActivity.this);
                        adbNationality.setTitle(R.string.nationality_title);
                        adbNationality.setMessage(R.string.nationality_msg);
                        adbNationality.setView(viewNationality);
                        adbNationality.setCancelable(false);
                        adbNationality.setNegativeButton(R.string.surname_btn_cencel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        adbNationality.setPositiveButton(R.string.surname_btn_set, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (pos != 0) {
                                    tv17.setText(nationality[pos]);
                                    view.setBackgroundColor(Color.rgb(0,25,25));
                                } else {
                                    Toast.makeText(getBaseContext(), "Do your choose", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        AlertDialog alertNationality = adbNationality.create();
                        alertNationality.show();
                        break;
                    case 3 :
                        datePickerDialog(view, tv15);
                        break;
                    case 4 :
                        LayoutInflater ltInflaterSex = getLayoutInflater();
                        final View viewSex = ltInflaterSex.inflate(R.layout.layout_sex, null, false);
                        //ActionBar.LayoutParams lpSex = (ActionBar.LayoutParams) viewSex.getLayoutParams();
                        //rgSex = (RadioGroup) viewSex.getRootView().findViewById(R.id.rg_sex);
                        rbSexM = (RadioButton) viewSex.getRootView().findViewById(R.id.rb_sex_m);
                        rbSexW = (RadioButton) viewSex.getRootView().findViewById(R.id.rb_sex_woman);
                        rbSexM.setText(R.string.rb_sex_m);
                        rbSexW.setText(R.string.rb_sex_woman);
                        if (tv13.getText().toString().equals(rbSexW.getText().toString())) {
                            rbSexW.setChecked(true);
                        }
                        final AlertDialog.Builder adbSex = new AlertDialog.Builder(MainActivity.this);
                        adbSex.setTitle(R.string.sex_title);
                        adbSex.setMessage(R.string.sex_msg);
                        adbSex.setView(viewSex);
                        adbSex.setCancelable(false);
                        adbSex.setNegativeButton(R.string.surname_btn_cencel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        adbSex.setPositiveButton(R.string.surname_btn_set, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (rbSexM.isChecked()) {
                                    sex = rbSexM.getText().toString();
                                } else {
                                    sex = rbSexW.getText().toString();
                                }
                                tv13.setText(sex);
                                view.setBackgroundColor(Color.rgb(0,25,25));
                            }
                        });
                        AlertDialog alertSex = adbSex.create();
                        alertSex.show();
                        break;
                    case 5 :
                        LayoutInflater ltInflaterPlace = getLayoutInflater();
                        final View viewPlace = ltInflaterPlace.inflate(R.layout.place_of_birth, null, false);
                        //ActionBar.LayoutParams lpPlace = (ActionBar.LayoutParams) viewPlace.getLayoutParams();
                        ll = (LinearLayout) viewPlace.getRootView().findViewById(R.id.ll);
                        spPlace = (Spinner) viewPlace.getRootView().findViewById(R.id.sp_place);
                        etPlace = (EditText) viewPlace.getRootView().findViewById(R.id.et_place);
                        if (!tv11.getText().toString().equals("")) {
                            String [] res = tv11.getText().toString().split(" / ");
                            etPlace.setText(res[0]);
                        }
                        place = getResources().getStringArray(R.array.place);
                        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getBaseContext(), R.array.place, android.R.layout.simple_list_item_1);
                        spPlace.setAdapter(aa);
                        spPlace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                posPlace = position;
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        final AlertDialog.Builder adbPlace = new AlertDialog.Builder(MainActivity.this);
                        adbPlace.setTitle(R.string.place_of_birth_title);
                        adbPlace.setMessage(R.string.place_of_birth_msg);
                        adbPlace.setView(viewPlace);
                        adbPlace.setCancelable(false);
                        adbPlace.setNegativeButton(R.string.surname_btn_cencel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        adbPlace.setPositiveButton(R.string.surname_btn_set, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (posPlace != 0) {
                                    tv11.setText(etPlace.getText().toString() + " / " + place[posPlace]);
                                    view.setBackgroundColor(Color.rgb(0,25,25));
                                } else {
                                    Toast.makeText(getBaseContext(), "Do your choose", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        AlertDialog alertPlace = adbPlace.create();
                        alertPlace.show();
                        break;
                    case 6 :
                        inputDigits(R.layout.layout_personal_no, etPersonalNo, R.id.etPersonal, R.string.personal_no_msg,
                                R.string.personal_no_title, tv9, view);
                        break;
                    case 7 :
                        datePickerDialog(view, tv7);
                        break;
                    case 8 :
                        datePickerDialog(view, tv5);
                        break;
                    case 9 :
                        inputDigits(R.layout.authority, etAuthority, R.id.etAuthority, R.string.authority_msg,
                                R.string.authority_title, tv3, view);
                        break;
                    case 10 :
                        LayoutInflater ltInflaterPassportNo = getLayoutInflater();
                        final View viewPassportNo = ltInflaterPassportNo.inflate(R.layout.layout_passport_no, null, false);
                        //ActionBar.LayoutParams lpPassportNo = (ActionBar.LayoutParams) viewPassportNo.getLayoutParams();
                        etSeries = (EditText) viewPassportNo.getRootView().findViewById(R.id.etSeries);
                        etNumber = (EditText) viewPassportNo.getRootView().findViewById(R.id.etNumber);
                        if (!tv1.getText().toString().equals("")) {
                            String [] res = tv1.getText().toString().split(" ");
                            etSeries.setText(res[0]);
                            etNumber.setText(res[1]);
                        }
                        final AlertDialog.Builder adbPassportNo = new AlertDialog.Builder(MainActivity.this);
                        adbPassportNo.setTitle(R.string.passport_no_title);
                        adbPassportNo.setMessage(R.string.passport_no_msg);
                        adbPassportNo.setView(viewPassportNo);
                        adbPassportNo.setCancelable(false);
                        adbPassportNo.setNegativeButton(R.string.surname_btn_cencel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        adbPassportNo.setPositiveButton(R.string.surname_btn_set, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tv1.setText(etSeries.getText().toString() + " " + etNumber.getText().toString());
                                view.setBackgroundColor(Color.rgb(0,25,25));
                            }
                        });
                        AlertDialog alertPassportNo = adbPassportNo.create();
                        alertPassportNo.show();
                        break;
                }
            }
        });
    }

    private void tvAddInArrayList() {
        tv = new ArrayList<>();
        tv.add(tv1);
        tv.add(tv3);
        tv.add(tv5);
        tv.add(tv7);
        tv.add(tv9);
        tv.add(tv11);
        tv.add(tv13);
        tv.add(tv15);
        tv.add(tv17);
        tv.add(tv19);
        tv.add(tv21);
    }

    private void inputDigits(int authority, EditText etAuthority, int etAuthority1, int authority_msg, int authority_title, final TextView tv, final View view) {
        LayoutInflater ltInflaterAuthority = getLayoutInflater();
        final View viewAuthority = ltInflaterAuthority.inflate(authority, null, false);
        //ActionBar.LayoutParams lpAuthority = (ActionBar.LayoutParams) viewAuthority.getLayoutParams();
        etAuthority = (EditText) viewAuthority.getRootView().findViewById(etAuthority1);
        final AlertDialog.Builder adbAuthority = new AlertDialog.Builder(MainActivity.this);
        adbAuthority.setTitle(authority_title);
        adbAuthority.setMessage(authority_msg);
        adbAuthority.setView(viewAuthority);
        adbAuthority.setCancelable(false);
        if (!tv.getText().toString().equals("")) {
            etAuthority.setText(tv.getText());
        }
        adbAuthority.setNegativeButton(R.string.surname_btn_cencel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        final EditText finalEtAuthority = etAuthority;
        adbAuthority.setPositiveButton(R.string.surname_btn_set, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText(finalEtAuthority.getText());
                view.setBackgroundColor(Color.rgb(0,25,25));
            }
        });
        AlertDialog alertAuthority = adbAuthority.create();
        alertAuthority.show();
    }

    private void datePickerDialog(View view, final TextView tv15) {
        DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                tv15.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
            }
        }, 2000, 12, 1);
        dpd.show();
        view.setBackgroundColor(Color.rgb(0,25,25));
    }

    private void tvNames() {
        tv18.setText(positions[2]);
        tv16.setText(positions[3]);
        tv14.setText(positions[4]);
        tv12.setText(positions[5]);
        tv10.setText(positions[6]);
        tv8.setText(positions[7]);
        tv6.setText(positions[8]);
        tv4.setText(positions[9]);
        tv2.setText(positions[10]);
        tv21.setText("");
        tv19.setText("");
        tv17.setText("");
        tv15.setText("");
        tv13.setText("");
        tv11.setText("");
        tv9.setText("");
        tv7.setText("");
        tv5.setText("");
        tv3.setText("");
        tv1.setText("");

    }

    private void tvFind() {
        tv22 = (TextView) findViewById(R.id.tv22);
        tv21 = (TextView) findViewById(R.id.tv21);
        tv20 = (TextView) findViewById(R.id.tv20);
        tv19 = (TextView) findViewById(R.id.tv19);
        tv18 = (TextView) findViewById(R.id.tv18);
        tv17 = (TextView) findViewById(R.id.tv17);
        tv16 = (TextView) findViewById(R.id.tv16);
        tv15 = (TextView) findViewById(R.id.tv15);
        tv14 = (TextView) findViewById(R.id.tv14);
        tv13 = (TextView) findViewById(R.id.tv13);
        tv12 = (TextView) findViewById(R.id.tv12);
        tv11 = (TextView) findViewById(R.id.tv11);
        tv10 = (TextView) findViewById(R.id.tv10);
        tv9 = (TextView) findViewById(R.id.tv9);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_about :
                Intent i = new Intent("android.intent.action.bla");
                startActivity(i);
                return true;
            case R.id.item_exit :
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        allInfo = "";
        for (TextView text : tv) {
            if (text.getText().toString().equals(""))
                text.setText("o");
            allInfo += text.getText().toString() + "##";
            if (text.getText().toString().equals("o"))
                text.setText("");
        }
        outState.putString(KEY, allInfo);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        allInfo = savedInstanceState.getString(KEY);
        String [] rePack = allInfo.split("##");
        for (int i = 0; i < rePack.length; i++) {
            for (int j = i; j < tv.size(); j++) {
                if(rePack[i].equals("o"))
                    rePack[i] = "";
                tv.get(j).setText(rePack[i]);
            }
        }
    }
}
