package com.example.resumebuilderapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ResumeInputActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone, etSummary, etExperience, etProjects, etSkills;
    private Button btnPreview;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "ResumeData"; // SharedPreferences Name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_input);

        // Initialize Views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etSummary = findViewById(R.id.etSummary);
        etExperience = findViewById(R.id.etExperience);
        etProjects = findViewById(R.id.etProjects);
        etSkills = findViewById(R.id.etSkills);
        btnPreview = findViewById(R.id.btnPreview);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Load Saved Data (If Available)
        loadSavedData();

        // Preview Button Click Listener
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String summary = etSummary.getText().toString().trim();
                String experience = etExperience.getText().toString().trim();
                String projects = etProjects.getText().toString().trim();
                String skills = etSkills.getText().toString().trim();

                // Debug Log
                Log.d("ResumeDebug", "Passing Data: " + name + ", " + email + ", " + phone + ", " + summary);

                // Save Data Before Previewing
                saveData(name, email, phone, summary, experience, projects, skills);

                // Send Data to Preview Activity
                Intent previewIntent = new Intent(ResumeInputActivity.this, ResumePreviewActivity.class);
                previewIntent.putExtra("name", name);
                previewIntent.putExtra("email", email);
                previewIntent.putExtra("phone", phone);
                previewIntent.putExtra("summary", summary);
                previewIntent.putExtra("experience", experience);
                previewIntent.putExtra("projects", projects);
                previewIntent.putExtra("skills", skills);
                startActivity(previewIntent);
            }
        });
    }

    // Load Data from SharedPreferences
    private void loadSavedData() {
        etName.setText(sharedPreferences.getString("name", ""));
        etEmail.setText(sharedPreferences.getString("email", ""));
        etPhone.setText(sharedPreferences.getString("phone", ""));
        etSummary.setText(sharedPreferences.getString("summary", ""));
        etExperience.setText(sharedPreferences.getString("experience", ""));
        etProjects.setText(sharedPreferences.getString("projects", ""));
        etSkills.setText(sharedPreferences.getString("skills", ""));
    }

    // Save Data to SharedPreferences
    private void saveData(String name, String email, String phone, String summary,
                          String experience, String projects, String skills) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("summary", summary);
        editor.putString("experience", experience);
        editor.putString("projects", projects);
        editor.putString("skills", skills);
        editor.apply(); // Save Data
        Log.d("ResumeDebug", "Resume Data Saved!");
    }
}
