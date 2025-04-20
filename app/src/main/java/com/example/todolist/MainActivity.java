package com.example.todolist;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TaskDatabase db;
    private TaskAdapter adapter;
    private List<Task> taskList;
    private EditText editTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = TaskDatabase.getInstance(this);
        taskList = db.taskDao().getAllTasks();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        editTask = findViewById(R.id.editTask);
        ImageButton btnAdd = findViewById(R.id.btnAdd);

        adapter = new TaskAdapter(taskList, db.taskDao());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            String title = editTask.getText().toString().trim();
            if (!title.isEmpty()) {
                Task newTask = new Task(title, false);
                db.taskDao().insert(newTask);
                taskList.clear();
                taskList.addAll(db.taskDao().getAllTasks());
                adapter.notifyDataSetChanged();
                editTask.setText("");
            }
        });
    }
}