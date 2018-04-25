package com.example.lucia.spaceinvaders;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends  AppCompatActivity implements OnClickListener  {
    Socket s;
    PrintWriter move;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    private String ip = "172.26.43.54";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensor==null)
            finish();
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d("Debbuger", "Move");
                float y = sensorEvent.values[1];
                //mueve a la izquierda
                if (y < -2) {
                    Log.d("Debbuger", "Left");
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                    try {
                        Log.d("Debbuger", "Creando socket");
                        s = new Socket(ip, 9000);
                        Log.d("Debbuger", "Creado");
                        move = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                        Log.d("Debbuger", "Moving");
                        move.println("Left");
                        Log.d("Debbuger", "Send");
                        s.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //mueve a la derecha
                } else if (y > 2) {
                    Log.d("Debbuger", "Right");
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                    try {
                        Log.d("Debbuger", "Creando sockete");
                        s = new Socket(ip, 9000);
                        Log.d("Debbuger", "Creado");
                        move = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                        Log.d("Debbuger", "Moving");
                        move.println("Right");
                        Log.d("Debbuger", "Send");
                        s.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        s = new Socket(ip, 9000);
                        move = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                        move.println("Nothing");
                        s.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };start();
    }

    private void start(){
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    public void onClick(View v) {
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.piu);
        mediaPlayer.start();
        getWindow().getDecorView().setBackgroundColor(Color.RED);
       try {
           Log.d("Debugger", "Fiahndo");
           s= new Socket(ip,9000);
           Log.d("Debugger", "Creando socket");
           move = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
           Log.d("Debugger", "Listo");
           move.println("FIRE!");
           Log.d("Debugger", "Enviando");
           s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }
}