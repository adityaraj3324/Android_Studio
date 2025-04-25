package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTitle, editDesc;
    Button btnAdd;
    RecyclerView recyclerView;
    TaskDatabase db;
    List<Task> taskList;
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesc);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);

        db = TaskDatabase.getInstance(this);
        taskList = db.taskDao().getAllTasks();

        adapter = new TaskAdapter(taskList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String desc = editDesc.getText().toString();
                if (!title.isEmpty()) {
                    Task task = new Task(title, desc);
                    db.taskDao().insert(task);
                    taskList.clear();
                    taskList.addAll(db.taskDao().getAllTasks());
                    adapter.notifyDataSetChanged();
                    editTitle.setText("");
                    editDesc.setText("");
                }
            }
        });
    }
}
