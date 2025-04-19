package com.example.resumebuilderapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResumePreviewActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "ResumeData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_preview);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPhone = findViewById(R.id.tvPhone);
        TextView tvSummary = findViewById(R.id.tvSummary);
        TextView tvExperience = findViewById(R.id.tvExperience);
        TextView tvProjects = findViewById(R.id.tvProjects);
        TextView tvSkills = findViewById(R.id.tvSkills);
        Button btnEdit = findViewById(R.id.btnEdit);
        Button btnSave = findViewById(R.id.btnSave);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String summary = intent.getStringExtra("summary");
        String experience = intent.getStringExtra("experience");
        String projects = intent.getStringExtra("projects");
        String skills = intent.getStringExtra("skills");

        tvName.setText(name != null ? name : "N/A");
        tvEmail.setText(email != null ? email : "N/A");
        tvPhone.setText(phone != null ? phone : "N/A");
        tvSummary.setText(summary != null ? summary : "N/A");
        tvExperience.setText(experience != null ? experience : "N/A");
        tvProjects.setText(projects != null ? projects : "N/A");
        tvSkills.setText(skills != null ? skills : "N/A");

        // 🔹 Edit Resume
        btnEdit.setOnClickListener(v -> {
            Intent editIntent = new Intent(ResumePreviewActivity.this, ResumeInputActivity.class);
            editIntent.putExtra("name", name);
            editIntent.putExtra("email", email);
            editIntent.putExtra("phone", phone);
            editIntent.putExtra("summary", summary);
            editIntent.putExtra("experience", experience);
            editIntent.putExtra("projects", projects);
            editIntent.putExtra("skills", skills);
            startActivity(editIntent);
        });

        // 🔹 Save Resume
        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String resumesJson = sharedPreferences.getString("resumes", "[]");

            JSONArray resumesArray;
            try {
                resumesArray = new JSONArray(resumesJson);
            } catch (JSONException e) {
                resumesArray = new JSONArray();
            }

            JSONObject resumeData = new JSONObject();
            try {
                resumeData.put("name", name);
                resumeData.put("email", email);
                resumeData.put("phone", phone);
                resumeData.put("summary", summary);
                resumeData.put("experience", experience);
                resumeData.put("projects", projects);
                resumeData.put("skills", skills);
                resumesArray.put(resumeData);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            editor.putString("resumes", resumesArray.toString());
            editor.apply();

            Toast.makeText(this, "Resume Saved!", Toast.LENGTH_SHORT).show();
            Log.d("ResumeDebug", "Resume Saved Successfully!");

            Intent mainIntent = new Intent(ResumePreviewActivity.this, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(mainIntent);
            finish();
        });
    }
}
