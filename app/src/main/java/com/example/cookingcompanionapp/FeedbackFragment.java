package com.example.cookingcompanionapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FeedbackFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_feedback, container, false);


        RatingBar ratingBar = view.findViewById(R.id.rating_bar);
        EditText feedbackEditText = view.findViewById(R.id.feedback_edit_text);
        Switch followUpSwitch = view.findViewById(R.id.follow_up_switch);
        Button submitButton = view.findViewById(R.id.submit_button);


        submitButton.setOnClickListener(v -> {
            // Get user input
            int rating = (int) ratingBar.getRating();
            String feedback = feedbackEditText.getText().toString();
            boolean followUp = followUpSwitch.isChecked();

            // Handle feedback submission (e.g., send to a server or store in local storage)
            // For now, we'll just clear the fields
            ratingBar.setRating(0); // Reset rating bar
            feedbackEditText.setText(""); // Clear feedback text
            followUpSwitch.setChecked(false); // Reset follow-up switch

            // Optional: Show a message or log the feedback for debugging
            // e.g., Log.d("FeedbackFragment", "Rating: " + rating + ", Feedback: " + feedback + ", Follow Up: " + followUp);
        });

        return view; // Return the inflated view
    }
}
