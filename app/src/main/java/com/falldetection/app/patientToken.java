package com.falldetection.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class patientToken extends AppCompatActivity {

    EditText edit;
    Button save, next;

    private static String value;
    public static String getValue() {
        return value;}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_token);

        edit= findViewById(R.id.edit);
        save = findViewById(R.id.save);
        next = findViewById(R.id.next);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edit.getText().toString().isEmpty()) {
                    String passingdata = edit.getText().toString();
                    //edit.setText(passingdata);

                    Toast.makeText(patientToken.this, "Token saved", Toast.LENGTH_SHORT).show();

                    value = passingdata.trim();
                }else {
                    Toast.makeText(patientToken.this, "Enter token", Toast.LENGTH_SHORT).show();

                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(patientToken.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}