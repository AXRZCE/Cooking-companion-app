package com.example.cookingcompanionapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.cookingcompanionapp.R;

public class TimerFragment extends Fragment {

    private TextView countdownText;
    private Button startButton, pauseButton, resetButton;
    private SeekBar timerSeekBar;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 3600000;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        // Initialize UI components
        countdownText = view.findViewById(R.id.countdown_text);
        startButton = view.findViewById(R.id.start_button);
        pauseButton = view.findViewById(R.id.pause_button);
        resetButton = view.findViewById(R.id.reset_button);
        timerSeekBar = view.findViewById(R.id.timer_seekbar);

        // Configure the SeekBar
        configureSeekBar();

        // Set up button click listeners
        startButton.setOnClickListener(v -> startTimer());
        pauseButton.setOnClickListener(v -> pauseTimer());
        resetButton.setOnClickListener(v -> resetTimer());

        return view; // Return the inflated view
    }

    // Method to configure the SeekBar
    private void configureSeekBar() {
        timerSeekBar.setMax(3600000); // Max duration set to 1 minute (60000 ms)
        timerSeekBar.setProgress(3600000); // Default progress set to 1 minute

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                timeLeftInMillis = progress; // Update time left in milliseconds
                updateCountdownText(); // Update displayed countdown text
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                pauseTimer();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                startTimer();
            }
        });
    }

    // Method to start the countdown timer
    private void startTimer() {
        if (timeLeftInMillis > 0) { // Ensure there's time left
            countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timeLeftInMillis = millisUntilFinished; // Update remaining time
                    updateCountdownText(); // Update displayed countdown text
                }

                @Override
                public void onFinish() {
                    countdownText.setText("Time's up!"); // Notify when time is up
                }
            }.start();
        }
    }

    // Method to pause the countdown timer
    private void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Cancel the timer
            countDownTimer = null;   // This line is important!
        }
    }

    // Method to reset the timer to default
    private void resetTimer() {
        pauseTimer(); // Ensure the timer is paused
        timeLeftInMillis = 3600000; // Reset to 1 minute
        updateCountdownText(); // Update displayed countdown text
        timerSeekBar.setProgress(3600000); // Reset SeekBar position
    }

    // Method to update the displayed countdown text
    private void updateCountdownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60; // Calculate minutes
        int seconds = (int) (timeLeftInMillis / 1000) % 60; // Calculate seconds

        // Format the time left and update the TextView
        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        countdownText.setText(timeLeftFormatted);
    }
}
