package com.example.mylris;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pbar;
    private int pbstats = 0;
    private final Handler handler = new Handler();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbar = (ProgressBar) findViewById(R.id.progressBar);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (pbstats < 100) {
                    pbstats += 3;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pbar.setProgress(pbstats);
                        }
                    });
                    try {
                        Thread.sleep(70);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        }).start();
    }
        public void zoom(View view){
            ImageView image = (ImageView)findViewById(R.id.imageView2);
            Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.clockwise);
            image.startAnimation(animation1);
        }

        }
