package com.example.H204H;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dfdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfdd);

        TextView textView = findViewById(R.id.noti);
        String message = getIntent().getStringExtra("message");
        textView.setText(message);

    }
}