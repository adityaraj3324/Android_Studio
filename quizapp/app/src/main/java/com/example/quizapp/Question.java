package com.example.quizapp;

public class Question {
    String questionText;
    String[] options;
    int correctIndex;

    public Question(String questionText, String[] options, int correctIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctIndex = correctIndex;
    }
}
