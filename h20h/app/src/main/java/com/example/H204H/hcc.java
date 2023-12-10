package com.example.H204H;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class hcc extends AppCompatActivity {


    private ProgressBar circular_pro;
    private Button click_btn;
    private TextView status;
    int i =100;

    private int progressStautus=0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcc);


        circular_pro=(ProgressBar)findViewById(R.id.pro);
        status=(TextView)findViewById(R.id.text1);



        //circular_pro=(ProgressBar)findViewById(R.id.pro);
        //status=(TextView)findViewById(R.id.text1);



        new Thread(new Runnable() {
            @Override
            public void run() {

                while (progressStautus<i){
                    progressStautus+=1;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            circular_pro.setProgress(progressStautus);
                            status.setText(progressStautus+"%");

                        }
                    });
                    try {
                        Thread.sleep(50);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }


            }
        }).start();


    }

}