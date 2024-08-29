package com.example.fintaskassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Main1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        TextView textView = findViewById(R.id.textView10);
        ImageView imageView = findViewById(R.id.imageView4);

        // Set click listener for TextView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main1.this, Register.class);
                startActivity(intent);
            }
        });

        // Set click listener for ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main1.this, Main2.class);
                startActivity(intent);
            }
        });
    }
}