package com.falldetection.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView txt5, txt6;
    Button btn1, btn2;
    SensorManager sensorManager;
    Sensor accelorometer , gyroscope, megnatometer;
    Boolean isaccavail, isgyroavail, ismegavail;
    Boolean isoriaccelcopied = false;
    Boolean isorimegcopied = false;
    float[] oriaccel = new float[3];
    float[] orimeg = new float[3];
    float[] orirotaion = new float[9];
    float[] orientation = new float[3];
    float time, accx, accy, accz, gyrox, gyroy, gyroz,pitch, roll, azimuth;
    String url = "https://fall-detection-app.herokuapp.com/";
    private static final String TAG = "MyActivity";
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 10000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt5 = findViewById(R.id.pred);

        txt6 = findViewById(R.id.viw);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        time = System.currentTimeMillis();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) !=null)
        {
           accelorometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
           isaccavail = true;
        }else
        {
            isaccavail = false;
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) !=null)
        {
            gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
            isgyroavail = true;
        }else {
            isgyroavail = false;
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) !=null)
        {
            megnatometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            ismegavail = true;
        }else {
            ismegavail = false;
        }
        if (isaccavail== true && isgyroavail== true && ismegavail== true){
            Toast.makeText(MainActivity.this, "Press start for taking readings", Toast.LENGTH_SHORT ).show();
        }else {
            new AlertDialog.Builder(this)
                    .setMessage("The app is not supported by this device. exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).setNegativeButton("No", null).show();
        }


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isaccavail)
                {

                    sensorManager.registerListener(MainActivity.this,accelorometer,SensorManager.SENSOR_DELAY_NORMAL);
                    sensorManager.registerListener(MainActivity.this, gyroscope,SensorManager.SENSOR_DELAY_NORMAL);
                    sensorManager.registerListener(MainActivity.this, megnatometer, SensorManager.SENSOR_DELAY_NORMAL);

                }

                handler.postDelayed(runnable = new Runnable() {
                    public void run() {
                        handler.postDelayed(runnable, delay);
                        //Toast.makeText(MainActivity.this, "This method is run every 10 seconds", Toast.LENGTH_SHORT).show();
                        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.audio);
                        mp.start();

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            String result = jsonObject.getString("prediction");
                                            if (result.equals("1")){

                                                txt5.setText(patientToken.getValue());

                                                FcmNotificationsSender notificationsSender = new FcmNotificationsSender(txt5.getText().toString(),
                                                        "ALERT",
                                                        "The patient is fallen Check out!",
                                                        getApplicationContext(),
                                                        MainActivity.this);
                                                notificationsSender.SendNotifications();
                                                    
                                                Toast.makeText(MainActivity.this,"Taking Reading", Toast.LENGTH_SHORT).show();
                                            }else {
                                                Toast.makeText(MainActivity.this,"Taking Reading", Toast.LENGTH_SHORT).show();

                                                txt6.setText("Normal Activity");
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(MainActivity.this, "Server Down: "+error.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }){

                            @Override
                            protected Map<String, String> getParams(){
                                Map<String, String> params = new HashMap<String,String>();
                                params.put("time", String.valueOf(time));
                                params.put("accx",String.valueOf(accx));
                                params.put("accy", String.valueOf(accy));
                                params.put("accz", String.valueOf(accz));
                                params.put("gyrox", String.valueOf(gyrox));
                                params.put("gyroy", String.valueOf(gyroy));
                                params.put("gyroz", String.valueOf(gyroz));
                                params.put("azimuth", String.valueOf(azimuth));
                                params.put("pitch", String.valueOf(pitch));
                                params.put("roll", String.valueOf(roll));

                                return params;
                            }

                        };

                        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                        queue.add(stringRequest);

                    }
                }, delay);



            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if (isaccavail)
               {
                    sensorManager.unregisterListener(MainActivity.this, accelorometer);
                    sensorManager.unregisterListener(MainActivity.this, gyroscope);
                    sensorManager.unregisterListener(MainActivity.this, megnatometer);

                    handler.removeCallbacks(runnable);
               }


            }
        });




    }



    public void onSensorChanged(SensorEvent sensorEvent) {


        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            accx = sensorEvent.values[0];
            accy = sensorEvent.values[1];
            accz = sensorEvent.values[2];
            Log.d(TAG, "acc x "+sensorEvent.values[0]+ " y " + sensorEvent.values[1] + " z " + sensorEvent.values[2]);
        }

        if (sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE) {

            gyrox = sensorEvent.values[0];
            gyroy = sensorEvent.values[1];
            gyroz = sensorEvent.values[2];

            Log.d(TAG, "gyro x "+sensorEvent.values[0]+ " y " + sensorEvent.values[1] + " z " + sensorEvent.values[2]);


        }

        if (sensorEvent.sensor == accelorometer){
            System.arraycopy(sensorEvent.values, 0,oriaccel, 0, sensorEvent.values.length);
            isoriaccelcopied = true;
        }else if (sensorEvent.sensor == megnatometer){
            System.arraycopy(sensorEvent.values, 0, orimeg, 0, sensorEvent.values.length);
            isorimegcopied = true;
        }

        if (isoriaccelcopied && isorimegcopied ){
            SensorManager.getRotationMatrix(orirotaion, null, oriaccel, orimeg);
            SensorManager.getOrientation(orirotaion, orientation);

            azimuth = sensorEvent.values[0];
            pitch = sensorEvent.values[1];
            roll = sensorEvent.values[2];

            Log.d(TAG, "ori a "+sensorEvent.values[0]+ " p " + sensorEvent.values[1] + " r " + sensorEvent.values[2]);
            
        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}