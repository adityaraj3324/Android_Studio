package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    TextView questionText;
    RadioGroup optionsGroup;
    Button nextButton;

    ArrayList<Question> questions;
    int currentQuestion = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        optionsGroup = findViewById(R.id.optionsGroup);
        nextButton = findViewById(R.id.btnNext);


        String subject = getIntent().getStringExtra("subject");
        questions = QuestionBank.getQuestionsForSubject(subject);

        loadQuestion();

        nextButton.setOnClickListener(v -> {
            int selectedId = optionsGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                int index = optionsGroup.indexOfChild(findViewById(selectedId));
                if (index == questions.get(currentQuestion).correctIndex) {
                    score++;
                }
                currentQuestion++;
                if (currentQuestion < questions.size()) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("score", score); // replace 'score' with your actual score variable
                    startActivity(intent);

                    finish();
                }
            }
        });
    }

    void loadQuestion() {
        Question q = questions.get(currentQuestion);
        questionText.setText(q.questionText);
        for (int i = 0; i < optionsGroup.getChildCount(); i++) {
            ((RadioButton) optionsGroup.getChildAt(i)).setText(q.options[i]);
        }
        optionsGroup.clearCheck();
    }
}
