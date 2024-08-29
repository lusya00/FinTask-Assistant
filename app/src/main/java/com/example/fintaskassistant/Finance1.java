package com.example.fintaskassistant;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Finance1 extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance1);

        editText1 = findViewById(R.id.editTextText5);
        editText2 = findViewById(R.id.editTextText6);
        editText3 = findViewById(R.id.editTextText7);
        editText4 = findViewById(R.id.editTextText8);
        button = findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();
                String text4 = editText4.getText().toString();

                Intent intent = new Intent(Finance1.this, Home.class);
                intent.putExtra("text1", text1);
                intent.putExtra("text2", text2);
                intent.putExtra("text3", text3);
                intent.putExtra("text4", text4);
                startActivity(intent);
            }
        });
    }
}
