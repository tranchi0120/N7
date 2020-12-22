package com.example.nhom7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.SeekBar;

import java.util.Random;

public class LoadingLoginActivity extends Activity {

    SeekBar sbLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadinglogin);
        sbLoading=(SeekBar) findViewById(R.id.seekbarLoading);
        final CountDownTimer countDownTimer=new CountDownTimer(60000,100) {
            @Override
            public void onTick(long l) {
                int number=10;
                Random random=new Random();
                int so=random.nextInt(number);
                int current;
                current = sbLoading.getProgress();
                if (current>=sbLoading.getMax()) {
                    this.cancel();
                    Intent myIntent=new Intent(LoadingLoginActivity.this, Home.class);
                    startActivity(myIntent);
                }

                sbLoading.setProgress(current + so);
                sbLoading.setSecondaryProgress(sbLoading.getProgress()+so);
            }

            @Override
            public void onFinish() {
                //chạy nữa

            }
        };
        countDownTimer.start();

    }
}
