package com.ivan.taskmanager.service;

import com.ivan.taskmanager.repository.TaskRepository;
import com.ivan.taskmanager.model.Task;

import java.util.List;

public class TaskService {

    private final  TaskRepository repository = new TaskRepository();

    public void addTask(String title){
        repository.save(new Task(title));
    }

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public boolean markTaskCompleted(int id){
        return repository.updateStatus(id, true);
    }

    public boolean deleteTask(int id){
        return repository.deleteById(id);
    }
}