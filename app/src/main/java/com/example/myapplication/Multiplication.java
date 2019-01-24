package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Multiplication extends AppCompatActivity {
    private final int[][] n = new int[3][3];
    private final int[][] adj = new int[3][3];
    private final EditText[][] et = new EditText[3][3];
    private final TextView txt = findViewById(R.id.result);
    int noOfTap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinant);
        Button btcal = findViewById(R.id.calc), btreset = findViewById(R.id.reset);
        et[0][0] = findViewById(R.id.editText1);
        et[0][1] = findViewById(R.id.editText2);
        et[0][2] = findViewById(R.id.editText3);
        et[1][0] = findViewById(R.id.editText4);
        et[1][1] = findViewById(R.id.editText5);
        et[1][2] = findViewById(R.id.editText6);
        et[2][0] = findViewById(R.id.editText7);
        et[2][1] = findViewById(R.id.editText8);
        et[2][2] = findViewById(R.id.editText9);

        btcal.setOnClickListener(v -> {
            getVal();


        });
        btreset.setOnClickListener(v -> {
            edoff(true);
            print(0);
        });
    }

    private void getVal() {
        if (noOfTap < 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String str = et[i][j].getText().toString();
                    if (str == null) {
                        Toast toast = Toast.makeText(getApplicationContext(), "enter all values in matrix", Toast.LENGTH_LONG);
                        toast.show();
                        return;
                    }
                    if (noOfTap == 0)
                        n[i][j] = Integer.parseInt(str);
                    else if (noOfTap == 1)
                        adj[i][j] = Integer.parseInt(str);
                }
            }
        } else {
            txt.setText("result");
            print(1);
            edoff(false);
        }
        noOfTap++;
    }

    private void print(int a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a == 1)
                    et[i][j].setText((adj[i][j] + n[i][j]) + "");
                else
                    et[i][j].setText(null);
            }
        }
    }

    private void edoff(boolean b) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                et[i][j].setEnabled(b);
            }
    }
}
