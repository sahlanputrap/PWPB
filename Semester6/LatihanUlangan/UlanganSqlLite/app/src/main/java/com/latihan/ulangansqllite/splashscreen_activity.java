package com.latihan.ulangansqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class splashscreen_activity extends AppCompatActivity {
    private int waktu=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(splashscreen_activity.this, activity_home.class);
                startActivity(home);
                finish();
            }
        },waktu);
    }
}
