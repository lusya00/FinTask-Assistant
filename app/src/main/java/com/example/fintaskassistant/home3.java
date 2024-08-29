package com.example.fintaskassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class home3 extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4;
    private ImageView imageViewNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);

        // Initialize views
        editText1 = findViewById(R.id.editTextText);
        editText2 = findViewById(R.id.editTextText2);
        editText3 = findViewById(R.id.editTextText3);
        editText4 = findViewById(R.id.editTextText4);
        imageViewNext = findViewById(R.id.imageView65);

        // Handle ImageView click
        imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from EditText fields
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();
                String text4 = editText4.getText().toString();

                // Create intent to start Home1
                Intent intent = new Intent(home3.this, Home1.class);
                intent.putExtra("text1", text1);
                intent.putExtra("text2", text2);
                intent.putExtra("text3", text3);
                intent.putExtra("text4", text4);
                startActivity(intent);
            }
        });
    }
}
