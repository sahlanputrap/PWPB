package com.latihan.sqllite;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_activity);

        Thread splash = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }
                catch (InterruptedException a){
                    a.printStackTrace();
                }
                finally {
                    startActivity(new Intent(splashActivity.this,homeActivity.class));
                    finish();
                }
            }
        };
        splash.start();
    }
}