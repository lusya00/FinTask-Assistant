package com.example.fintaskassistant;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.menuHome) {
                    selectedFragment = new HomeFragment();
                } else if (itemId == R.id.menuCalendar) {
                    selectedFragment = new CalendarFragment();
                } else if (itemId == R.id.menuFocuse) {
                    selectedFragment = new FocuseFragment();
                } else if (itemId == R.id.menuProfile) {
                    selectedFragment = new ProfileFragment();
                } else if (itemId == R.id.finance) {
                    selectedFragment = new FinanceFragment();
                } else {
                    return false; // If none of the items match
                }

                // Check if the selected fragment is FinanceFragment and handle data transfer
                if (itemId == R.id.finance) {
                    String text1 = getIntent().getStringExtra("text1");
                    String text2 = getIntent().getStringExtra("text2");
                    String text3 = getIntent().getStringExtra("text3");
                    String text4 = getIntent().getStringExtra("text4");

                    Bundle bundle = new Bundle();
                    bundle.putString("text1", text1);
                    bundle.putString("text2", text2);
                    bundle.putString("text3", text3);
                    bundle.putString("text4", text4);

                    FinanceFragment financeFragment = new FinanceFragment();
                    financeFragment.setArguments(bundle);

                    selectedFragment = financeFragment;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });

        // Set default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
}
