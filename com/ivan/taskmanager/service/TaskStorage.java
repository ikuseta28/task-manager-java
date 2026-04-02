package com.ivan.taskmanager.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ivan.taskmanager.model.Task;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private static final String FILE_PATH = "tasks.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Task> loadTasks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (FileReader reader = new FileReader(file)) {
            Type taskListType = new TypeToken<List<Task>>(){}.getType();
            List<Task>tasks = gson.fromJson(reader, taskListType);
            return tasks != null ? tasks : new ArrayList<>();
        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveTasks(List<Task> tasks){
        try(FileWriter writer = new FileWriter(FILE_PATH)){
            gson.toJson(tasks, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
