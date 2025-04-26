package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get the intent that started this activity
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        // Display score
        TextView resultText = findViewById(R.id.resultText);
        resultText.setText("Your score is: " + score + " / 5");
    }
}
