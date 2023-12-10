package com.example.H204H;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {
    Button button;

    int d=10;


    /*public static final String cid = "buddhika_id";
    public static final String cname = "buddhika_name";
    public static final String cdesc = "buddhika_desc";

     */












    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startService(new Intent(this, NotificationService.class));








/*

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
            NotificationChannel channel = new NotificationChannel
                    (cid,cname, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(cdesc);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

 */
/*
        int x=750;


        final int[] initialx = {x};
        //code that may or may not change the value of x
        x=748;//blutooth


        final Handler handler = new Handler();
        int finalX = x;



        button = findViewById(R.id.but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //Check something after 60 seconds

                        if (finalX == initialx[0] || finalX ==(initialx[0] -1) || finalX ==(initialx[0] -2)||
                                finalX ==(initialx[0] -3) || finalX ==(initialx[0] -4) || finalX ==(initialx[0] -5)){

                            //doOneTimeTaskIfVariableHasChanged();
                            displayNotification();




                            initialx[0] = finalX;
                            //reset initialx for future change tests
                        }



                        handler.postDelayed(this, 10000); //1000ms = 1seconds * 60
                    }
                }, 20000); // first trigger 1ms. change this if you want to starts at 60 sec make it 60000




            }
        });

 */



        button=findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(MainActivity.this,blu.class);
                //startActivity(intent);


                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    // Device does not support Bluetooth
                } else if (!mBluetoothAdapter.isEnabled()) {
                    // Bluetooth is not enabled :)


                    Toast.makeText(getApplicationContext(),"Please Pair the Device first",Toast.LENGTH_SHORT).show();
                    openDialog1();






                } else {
                    // Bluetooth is enabled


                    openDialog();
                    button.setText("Connected");
                    button.setBackgroundColor(Color.BLUE);













                }






            }
        });


    }


    protected void onStop () {
        super .onStop() ;


    }




    public void openDialog1(){

        exDialog ef = new exDialog();
        ef.show(getSupportFragmentManager(),"ex dialog");

    }

    public void openDialog(){

        exampleDialog ex=new exampleDialog();
        ex.show(getSupportFragmentManager(),"example dialog");
    }



/*

    public void displayNotification(){

        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this,cid)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("New Notification")
                .setContentText("this is notification")
                //.setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);



        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1,mbuilder.build());

    }

 */



}

