package oka.codedieux.com.restaurant.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import oka.codedieux.com.restaurant.R;

public class LauncherActivity extends AppCompatActivity {
    final int splash_timout = 8000;//4 seconds

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        setContentView(R.layout.activity_launcher);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                 Intent loginActivity = new Intent(LauncherActivity.this, LoginActivity.class);

                startActivity(loginActivity);
                finish();
            }
        }, splash_timout);


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}