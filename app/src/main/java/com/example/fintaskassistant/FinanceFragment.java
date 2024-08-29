package com.example.fintaskassistant;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FinanceFragment extends Fragment {

    private TextView textView1, textView2, textView3, textView4;

    public FinanceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finance, container, false);

        textView1 = view.findViewById(R.id.textView81);
        textView2 = view.findViewById(R.id.textView82);
        textView3 = view.findViewById(R.id.textView83);
        textView4 = view.findViewById(R.id.textView84);

        Bundle bundle = getArguments();
        if (bundle != null) {
            textView1.setText(bundle.getString("text1"));
            textView2.setText(bundle.getString("text2"));
            textView3.setText(bundle.getString("text3"));
            textView4.setText(bundle.getString("text4"));
        }

        ImageView imageView = view.findViewById(R.id.imageView67);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity
                Intent intent = new Intent(getActivity(), Finance1.class);
                startActivity(intent);
            }
        });

        return view;
    }

    // Method to handle ImageView click
    public void navigateToNewActivity(View view) {
        // Navigate to another activity
        Intent intent = new Intent(getActivity(), Finance1.class);
        startActivity(intent);
    }
}
