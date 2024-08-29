package com.example.fintaskassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Home1 extends AppCompatActivity {

    private ListView listViewText;
    private ArrayList<String> textList;
    private ArrayAdapter<String> adapter;
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        // Initialize views
        listViewText = findViewById(R.id.listview1);
        imageView1 = findViewById(R.id.imageView23);
        imageView2 = findViewById(R.id.imageView28);

        // Initialize textList and adapter
        textList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, textList);
        listViewText.setAdapter(adapter);

        // Get data from previous activity (Home3) if available
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String text1 = extras.getString("text1");
            String text2 = extras.getString("text2");
            String text3 = extras.getString("text3");
            String text4 = extras.getString("text4");

            // Add data to textList
            textList.add(text1);
            textList.add(text2);
            textList.add(text3);
            textList.add(text4);

            // Notify adapter about data changes
            adapter.notifyDataSetChanged();
        }

        // Set click listener for imageView1
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home1.this, home3.class);
                startActivity(intent);
            }
        });

        // Set click listener for imageView2
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home1.this, home2.class);
                startActivity(intent);
            }
        });
    }
}
