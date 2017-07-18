package widget.shag.edu.widgetapplication;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import layout.WidgetColor;

public class ChooseColorActivity extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnKeyListener{

    private Button btnOk;
    private TextView tvColors;
    private SeekBar sbRed, sbGreen, sbBlue;
    private EditText etRed, etGreen, etBlue;
    private int progressRed, progressGreen, progressBlue;


    int widgetID = AppWidgetManager.INVALID_APPWIDGET_ID;
    private Intent res;
    public final static String WIDGET_PREF = "widget_pref";
    public final static String WIDGET_TEXT = "widget_text_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String color = intent.getStringExtra("no");

        Bundle extras = intent.getExtras();

        if (extras != null) {
            widgetID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        if (widgetID == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }

        res = new Intent();
        res.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
        setResult(RESULT_CANCELED, res);

        setContentView(R.layout.activity_choose_color);

        btnOk = (Button) findViewById(R.id.btnOk);
        tvColors = (TextView) findViewById(R.id.tvColors);
        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);
        etRed = (EditText) findViewById(R.id.etRed);
        etGreen = (EditText) findViewById(R.id.etGreen);
        etBlue = (EditText) findViewById(R.id.etBlue);

        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);

        etRed.setOnKeyListener(this);
        etGreen.setOnKeyListener(this);
        etBlue.setOnKeyListener(this);

        if (WidgetColor.result != null) {
            String [] r = WidgetColor.result.split(" ");
            sbRed.setProgress(Integer.parseInt(r[0]));
            sbGreen.setProgress(Integer.parseInt(r[1]));
            sbBlue.setProgress(Integer.parseInt(r[2]));
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences(WIDGET_PREF, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(WIDGET_TEXT + widgetID, progressRed + " " + progressGreen + " " + progressBlue);
                editor.commit();
                setResult(RESULT_OK, res);
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getApplicationContext());
                WidgetColor.updateAppWidget(getApplicationContext(), appWidgetManager, widgetID);
                finish();
            }
        });
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN &&
                (keyCode == KeyEvent.KEYCODE_ENTER))
        {
            switch (v.getId()) {
                case R.id.etRed :
                    if(etRed.getText().toString().equals("")) {
                        etRed.setText("0");
                    }
                    if(Integer.parseInt(etRed.getText().toString()) > 255){
                        etRed.setText("255");
                    }
                    sbRed.setProgress(Integer.parseInt(etRed.getText().toString()));
                    break;
                case R.id.etGreen :
                    if(etGreen.getText().toString().equals("")) {
                        etGreen.setText("0");
                    }
                    if(Integer.parseInt(etGreen.getText().toString()) > 255){
                        etGreen.setText("255");
                    }
                    sbGreen.setProgress(Integer.parseInt(etGreen.getText().toString()));
                    break;
                case R.id.etBlue :
                    if(etBlue.getText().toString().equals("")) {
                        etBlue.setText("0");
                    }
                    if(Integer.parseInt(etBlue.getText().toString()) > 255){
                        etBlue.setText("255");
                    }
                    sbBlue.setProgress(Integer.parseInt(etBlue.getText().toString()));
                    break;
            }
            return true;
        }
        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        etRed.setText(String.valueOf(sbRed.getProgress()));
        etGreen.setText(String.valueOf(sbGreen.getProgress()));
        etBlue.setText(String.valueOf(sbBlue.getProgress()));
        progressRed = sbRed.getProgress();
        progressGreen = sbGreen.getProgress();
        progressBlue = sbBlue.getProgress();
        tvColors.setBackgroundColor(Color.rgb(progressRed, progressGreen, progressBlue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
