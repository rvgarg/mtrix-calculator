package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Determinant extends AppCompatActivity {
    private final int[][] a = new int[3][3];
    private final EditText[][] et = new EditText[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinant);
        TextView txt = findViewById(R.id.result);
        et[0][0] = findViewById(R.id.editText1);
        et[0][1] = findViewById(R.id.editText2);
        et[0][2] = findViewById(R.id.editText3);
        et[1][0] = findViewById(R.id.editText4);
        et[1][1] = findViewById(R.id.editText5);
        et[1][2] = findViewById(R.id.editText6);
        et[2][0] = findViewById(R.id.editText7);
        et[2][1] = findViewById(R.id.editText8);
        et[2][2] = findViewById(R.id.editText9);
        Button btcal = findViewById(R.id.calc), btreset = findViewById(R.id.reset);
        btcal.setOnClickListener(v -> {
            getVal();
            int ans = cal(a);

            txt.setText("" + ans);
            edoff(false);
        });
        btreset.setOnClickListener(v -> {
            txt.setText("Result");
            edoff(true);
            print();
        });
    }

    private void getVal() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = Integer.parseInt(et[i][j].getText().toString());
            }
        }
    }

    public int cal(int a[][]) {
        int fin, l, m, r;
        l = a[1][1] * a[2][2] - a[1][2] * a[2][1];
        m = a[1][0] * a[2][2] - a[1][2] * a[2][0];
        r = a[1][0] * a[2][1] - a[1][1] * a[2][0];
        fin = a[0][0] * l - a[0][1] * m + a[0][2] * r;
        return fin;
    }

    private void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                et[i][j].setText(null);
            }
        }
    }

    private void edoff(boolean k) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                et[i][j].setEnabled(k);
            }
    }
}
