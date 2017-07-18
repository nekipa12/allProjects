package next.shag.edu.filemanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RedactorActivity extends AppCompatActivity {

    private EditText et;
    private Button btnSave, btnCancel;
    private String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redactor);

        et = (EditText) findViewById(R.id.et);
        res = getIntent().getStringExtra(Fragment1.KEY);
        //et.setText(res);
        try {
            Scanner sc = new Scanner(new FileInputStream(res));
            while (sc.hasNextLine()) {
                et.setText(sc.nextLine());
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        btnSave = (Button) findViewById(R.id.btnSave);
        btnCancel = (Button) findViewById(R.id.btnCencel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(res, false)));
                    pw.write(et.getText().toString() + "\r\n");
                    pw.flush();
                    pw.close();
                    finish();
                } catch (FileNotFoundException e) {
                    finish();
                    e.printStackTrace();
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
