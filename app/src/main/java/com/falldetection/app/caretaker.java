package com.falldetection.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class caretaker extends AppCompatActivity {

    TextView text;
    ImageView copy, share;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caretaker);

        text = findViewById(R.id.text);
        copy = findViewById(R.id.copy);
        share = findViewById(R.id.share);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //copy to clipboard
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Text", text.getText().toString());
                clipboardManager.setPrimaryClip(clipData);

                copy.setImageDrawable(getResources().getDrawable(R.drawable.done));

                Toast.makeText(caretaker.this, "Token copied to clipboard", Toast.LENGTH_SHORT).show();

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
                intent.setType("text/plain");
                intent=Intent.createChooser(intent,"share");
                startActivity(intent);
            }
        });


        // fcm settings for perticular user
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        //String msg = "fall detection";
                        if (!task.isSuccessful()) {
                            Log.d("Success","Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        token = task.getResult();

                        // Log and
                        Log.d("Success","device registration token"+token);
                        text.setText(token);
                    }
                });



    }

}