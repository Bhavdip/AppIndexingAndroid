package com.android.skillvo.appindexing;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.skillvo.appindexing.databinding.SplashDataBinding;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SPLASH_TIMEOUT = 3000;
    private SplashDataBinding mSplashDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_spalsh);
        startSplashScreen();
    }

    private void startSplashScreen() {
        Timer buttonTimer = new Timer();
        buttonTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mSplashDataBinding.textViewSplashScreen.setVisibility(View.VISIBLE);
                        mSplashDataBinding.btnHomeScreen.setOnClickListener(SplashActivity.this);
                        mSplashDataBinding.btnHomeScreen.setVisibility(View.VISIBLE);
                    }
                });
            }
        }, SPLASH_TIMEOUT);
    }

    @Override
    public void onClick(View view) {
        HomeActivity.startHomeActivity(this);
        finish();
    }
}
