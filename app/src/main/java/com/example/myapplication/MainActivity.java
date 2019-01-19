package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button addition;
    private Button multiplication;
    private Button adjoint;
    private Button determinant;
    private Button transpose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addition = findViewById(R.id.addition);
        adjoint = findViewById(R.id.adjoint);
        multiplication = findViewById(R.id.multiplication);
        determinant = findViewById(R.id.determinant);
        transpose = findViewById(R.id.transpose);
        addition.setOnClickListener(v -> {
            Intent intent = new Intent(this, Addition.class);
            startActivity(intent);
        });
        adjoint.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, Adjoint.class);
            startActivity(intent);
        });
        multiplication.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, Multiplication.class);
            startActivity(intent);

        });
        transpose.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, Transpose.class);
            startActivity(intent);

        });
        determinant.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, Determinant.class);
            startActivity(intent);

        });
    }
}
