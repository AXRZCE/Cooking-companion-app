package com.example.cookingcompanionapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView imageView = view.findViewById(R.id.home_image);
        TextView welcomeText = view.findViewById(R.id.welcome_text);


        welcomeText.setText("Welcome to the Cooking Companion App!");
        imageView.setImageResource(R.drawable.culinary_image);

        return view;
    }
}