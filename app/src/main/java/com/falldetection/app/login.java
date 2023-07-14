package com.falldetection.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private long backPressTime;
    private Toast backtoast;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn1 = findViewById(R.id.ptient);
        btn2 = findViewById(R.id.caretaker);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, patientToken.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, caretaker.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (backPressTime + 2000 > System.currentTimeMillis()){
            backtoast.cancel();
            super.onBackPressed();
            return;
        }else {
            backtoast = Toast.makeText(login.this, "Press back again to exit", Toast.LENGTH_SHORT);
            backtoast.show();
        }
        backPressTime= System.currentTimeMillis();



    }
}