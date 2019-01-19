package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Adjoint extends AppCompatActivity {
    private final int[][] a = new int[3][3];
    private final int[][] adj = new int[3][3];
    private final EditText[][] et = new EditText[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinant);
        TextView txt = findViewById(R.id.result);
        txt.setVisibility(View.INVISIBLE);
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
            adjoint();
            txt.setText("Adjoint of matrix");
            print(1);
            edoff(false);
        });
        btreset.setOnClickListener(v -> {
            edoff(true);
            print(0);
        });
    }

    private void getVal() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                String str = et[i][j].getText().toString();
                if (str == null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "enter all values in matrix", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                a[i][j] = Integer.parseInt(str);

            }
    }

    private void print(int a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a == 1)
                    et[i][j].setText(adj[j][i] + "");
                else
                    et[i][j].setText(null);
            }
        }
    }

    private void adjoint() {
        adj[0][0] = a[1][1] * a[2][2] - a[1][2] * a[2][1];
        adj[0][1] = a[1][0] * a[2][2] - a[0][2] * a[2][1];
        adj[0][2] = a[1][0] * a[2][1] - a[1][1] * a[2][0];
        adj[1][0] = a[0][1] * a[2][2] - a[0][2] * a[2][1];
        adj[1][1] = a[0][0] * a[2][2] - a[0][2] * a[2][0];
        adj[1][2] = a[0][0] * a[2][1] - a[0][1] * a[2][0];
        adj[2][0] = a[0][1] * a[1][0] - a[1][1] * a[2][0];
        adj[2][1] = a[1][2] * a[0][0] - a[1][0] * a[0][2];
        adj[2][2] = a[0][0] * a[1][1] - a[1][0] * a[0][1];
    }

    private void edoff(boolean b) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                et[i][j].setEnabled(b);
            }
    }
}
