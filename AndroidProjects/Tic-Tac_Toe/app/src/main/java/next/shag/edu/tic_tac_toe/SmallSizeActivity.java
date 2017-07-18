package next.shag.edu.tic_tac_toe;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class SmallSizeActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Button> alb;
    private Fragment f00, f01, f02, f10, f11, f12, f20, f21, f22;
    private Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;
    private int counter;
    private boolean res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_size);
        alb = new ArrayList<>();
        Intent i = getIntent();
        res = i.getBooleanExtra(MainActivity.KEY, true);
        findFragments();
        findBtn();
        btnSetId();
        addInArray();
        btnOnClic();
    }
    private void addInArray() {
        alb.add(btn00);
        alb.add(btn01);
        alb.add(btn02);
        alb.add(btn10);
        alb.add(btn11);
        alb.add(btn12);
        alb.add(btn20);
        alb.add(btn21);
        alb.add(btn22);
    }

    private void btnSetId() {
        btn00.setId(Integer.parseInt("00"));
        btn01.setId(Integer.parseInt("01"));
        btn02.setId(Integer.parseInt("02"));
        btn10.setId(Integer.parseInt("10"));
        btn11.setId(Integer.parseInt("11"));
        btn12.setId(Integer.parseInt("12"));
        btn20.setId(Integer.parseInt("20"));
        btn21.setId(Integer.parseInt("21"));
        btn22.setId(Integer.parseInt("22"));

    }

    private void btnOnClic() {
        btn00.setOnClickListener(this);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
    }

    private void findBtn() {
        btn00 = (Button) f00.getView().findViewById(R.id.button);
        btn01 = (Button) f01.getView().findViewById(R.id.button);
        btn02 = (Button) f02.getView().findViewById(R.id.button);
        btn10 = (Button) f10.getView().findViewById(R.id.button);
        btn11 = (Button) f11.getView().findViewById(R.id.button);
        btn12 = (Button) f12.getView().findViewById(R.id.button);
        btn20 = (Button) f20.getView().findViewById(R.id.button);
        btn21 = (Button) f21.getView().findViewById(R.id.button);
        btn22 = (Button) f22.getView().findViewById(R.id.button);
    }

    private void findFragments() {
        f00 = getFragmentManager().findFragmentById(R.id.fragment_00);
        f01 = getFragmentManager().findFragmentById(R.id.fragment_01);
        f02 = getFragmentManager().findFragmentById(R.id.fragment_02);
        f10 = getFragmentManager().findFragmentById(R.id.fragment_10);
        f11 = getFragmentManager().findFragmentById(R.id.fragment_11);
        f12 = getFragmentManager().findFragmentById(R.id.fragment_12);
        f20 = getFragmentManager().findFragmentById(R.id.fragment_20);
        f21 = getFragmentManager().findFragmentById(R.id.fragment_21);
        f22 = getFragmentManager().findFragmentById(R.id.fragment_22);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case 00:
                if ((counter % 2) == 0) {
                    btn00.setText("x");
                    btn00.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn00.setText("O");
                    btn00.setBackgroundResource(R.drawable.o);
                }
                btn00.setEnabled(false);
                break;
            case 01:
                if ((counter % 2) == 0) {
                    btn01.setText("x");
                    btn01.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn01.setText("O");
                    btn01.setBackgroundResource(R.drawable.o);
                }
                btn01.setEnabled(false);
                break;
            case 02:
                if ((counter % 2) == 0) {
                    btn02.setText("x");
                    btn02.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn02.setText("O");
                    btn02.setBackgroundResource(R.drawable.o);
                }
                btn02.setEnabled(false);
                break;
            case 10:
                if ((counter % 2) == 0) {
                    btn10.setText("x");
                    btn10.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn10.setText("O");
                    btn10.setBackgroundResource(R.drawable.o);
                }
                btn10.setEnabled(false);
                break;
            case 11:
                if ((counter % 2) == 0) {
                    btn11.setText("x");
                    btn11.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn11.setText("O");
                    btn11.setBackgroundResource(R.drawable.o);
                }
                btn11.setEnabled(false);
                break;
            case 12:
                if ((counter % 2) == 0) {
                    btn12.setText("x");
                    btn12.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn12.setText("O");
                    btn12.setBackgroundResource(R.drawable.o);
                }
                btn12.setEnabled(false);
                break;
            case 20:
                if ((counter % 2) == 0) {
                    btn20.setText("x");
                    btn20.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn20.setText("O");
                    btn20.setBackgroundResource(R.drawable.o);
                }
                btn20.setEnabled(false);
                break;
            case 21:
                if ((counter % 2) == 0) {
                    btn21.setText("x");
                    btn21.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn21.setText("O");
                    btn21.setBackgroundResource(R.drawable.o);
                }
                btn21.setEnabled(false);
                break;
            case 22:
                if ((counter % 2) == 0) {
                    btn22.setText("x");
                    btn22.setBackgroundResource(R.drawable.x);
                }
                else {
                    btn22.setText("O");
                    btn22.setBackgroundResource(R.drawable.o);
                }
                btn22.setEnabled(false);
                break;

        }
        counter++;
        if (counter > 4) {
            check();
        }
        if (res == false) {

            stepOpponent();
            if (counter > 4) {
                check();
            }
        }


    }

    private void stepOpponent() {
        counter++;
        Collections.shuffle(alb);
        for (Button btn : alb) {
            if (btn.getText().equals("")) {
                btn.setText("O");
                btn.setBackgroundResource(R.drawable.o);
                btn.setEnabled(false);
                break;
            }
        }
    }

    private void check() {
        if (btn00.getText().equals("x") && btn01.getText().equals("x") && btn02.getText().equals("x")) {
            Toast.makeText(getBaseContext(), "x is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn10.getText().equals("x") && btn11.getText().equals("x") && btn12.getText().equals("x")) {
            Toast.makeText(getBaseContext(), "x is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn20.getText().equals("x") && btn21.getText().equals("x") && btn22.getText().equals("x")) {
            Toast.makeText(getBaseContext(), "x is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn00.getText().equals("x") && btn10.getText().equals("x") && btn20.getText().equals("x")) {
            Toast.makeText(getBaseContext(), "x is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn01.getText().equals("x") && btn11.getText().equals("x") && btn21.getText().equals("x")) {
            Toast.makeText(getBaseContext(), "x is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn02.getText().equals("x") && btn12.getText().equals("x") && btn22.getText().equals("x")) {
            Toast.makeText(getBaseContext(), "x is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn00.getText().equals("x") && btn11.getText().equals("x") && btn22.getText().equals("x")) {
            Toast.makeText(getBaseContext(), "x is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn02.getText().equals("x") && btn11.getText().equals("x") && btn20.getText().equals("x")) {
            Toast.makeText(getBaseContext(), "x is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn00.getText().equals("O") && btn01.getText().equals("O") && btn02.getText().equals("O")) {
            Toast.makeText(getBaseContext(), "O is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn10.getText().equals("O") && btn11.getText().equals("O") && btn12.getText().equals("O")) {
            Toast.makeText(getBaseContext(), "O is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn20.getText().equals("O") && btn21.getText().equals("O") && btn22.getText().equals("O")) {
            Toast.makeText(getBaseContext(), "O is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn00.getText().equals("O") && btn10.getText().equals("O") && btn20.getText().equals("O")) {
            Toast.makeText(getBaseContext(), "O is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn01.getText().equals("O") && btn11.getText().equals("O") && btn21.getText().equals("O")) {
            Toast.makeText(getBaseContext(), "O is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn02.getText().equals("O") && btn12.getText().equals("O") && btn22.getText().equals("O")) {
            Toast.makeText(getBaseContext(), "O is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn00.getText().equals("O") && btn11.getText().equals("O") && btn22.getText().equals("O")) {
            Toast.makeText(getBaseContext(), "O is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (btn02.getText().equals("O") && btn11.getText().equals("O") && btn20.getText().equals("O")) {
            Toast.makeText(getBaseContext(), "O is winner", Toast.LENGTH_SHORT).show();
            finish();
        } else if (counter == 9){
            Toast.makeText(getBaseContext(), "Nobody win", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
