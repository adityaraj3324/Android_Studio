package com.example.resumebuilderapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btnCreateResume, btnViewSavedResume, btnDeleteAllResumes,btnExit;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "ResumeData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateResume = findViewById(R.id.btnCreateResume);
        btnViewSavedResume = findViewById(R.id.btnViewSavedResume);
        btnDeleteAllResumes = findViewById(R.id.btnDeleteAllResumes);
        btnExit = findViewById(R.id.btnExit);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // 🔹 Open Resume Input Activity
        btnCreateResume.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResumeInputActivity.class);
            startActivity(intent);
        });

        // 🔹 View Last Saved Resume
        btnViewSavedResume.setOnClickListener(v -> {
            String resumesJson = sharedPreferences.getString("resumes", "[]");
            JSONArray resumesArray;
            try {
                resumesArray = new JSONArray(resumesJson);
            } catch (JSONException e) {
                resumesArray = new JSONArray();
            }

            if (resumesArray.length() == 0) {
                Toast.makeText(MainActivity.this, "No saved resumes found!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                JSONObject lastResume = resumesArray.getJSONObject(resumesArray.length() - 1);

                Intent previewIntent = new Intent(MainActivity.this, ResumePreviewActivity.class);
                previewIntent.putExtra("name", lastResume.optString("name", "N/A"));
                previewIntent.putExtra("email", lastResume.optString("email", "N/A"));
                previewIntent.putExtra("phone", lastResume.optString("phone", "N/A"));
                previewIntent.putExtra("summary", lastResume.optString("summary", "N/A"));
                previewIntent.putExtra("experience", lastResume.optString("experience", "N/A"));
                previewIntent.putExtra("projects", lastResume.optString("projects", "N/A"));
                previewIntent.putExtra("skills", lastResume.optString("skills", "N/A"));
                startActivity(previewIntent);

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Error loading resume!", Toast.LENGTH_SHORT).show();
            }
        });

        // 🔹 Delete All Resumes
        btnDeleteAllResumes.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("resumes");
            editor.apply();
            Toast.makeText(MainActivity.this, "All resumes deleted!", Toast.LENGTH_SHORT).show();
        });

        btnExit.setOnClickListener(v -> {
            finishAffinity(); // Close all activities and exit the app
        });
    }
}
