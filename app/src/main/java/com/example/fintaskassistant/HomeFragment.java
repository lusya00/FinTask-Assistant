package com.example.fintaskassistant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class HomeFragment extends Fragment {
        public HomeFragment() {
            // Diperlukan konstruktor kosong
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_home, container, false);

            ImageView imageView = view.findViewById(R.id.imageView68);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("HomeFragment", "ImageView clicked. Starting Home1 activity.");
                    Intent intent = new Intent(getActivity(), Home1.class);
                    startActivity(intent);
                }
        });
            return view;
        }
    }
