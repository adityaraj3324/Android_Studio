package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnHindi).setOnClickListener(v -> launchQuiz("Hindi"));
        findViewById(R.id.btnEnglish).setOnClickListener(v -> launchQuiz("English"));
        findViewById(R.id.btnPhysics).setOnClickListener(v -> launchQuiz("Physics"));
        findViewById(R.id.btnMaths).setOnClickListener(v -> launchQuiz("Maths"));
        findViewById(R.id.btnChemistry).setOnClickListener(v -> launchQuiz("Chemistry"));
    }

    void launchQuiz(String subject) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("subject", subject);
        startActivity(intent);
    }
}
