package com.example.todolistapp;

import androidx.room.*;
import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(Task task);

    @Query("SELECT * FROM Task")
    List<Task> getAllTasks();

    @Delete
    void delete(Task task);
}
