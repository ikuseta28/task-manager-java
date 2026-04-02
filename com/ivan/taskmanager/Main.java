package com.ivan.taskmanager;

import com.ivan.taskmanager.model.Task;
import com.ivan.taskmanager.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskService service = new TaskService();

        while (true){
            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark task as done");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");


            int choice = readInt(scanner, "Choose: ");

            List<Task> tasks;


        switch (choice) {
            case 1 -> {
                System.out.println("Enter task title: ");
                String title = scanner.nextLine();
                service.addTask(title);
                System.out.println("Task added!");
        }

            case 2 -> {
                tasks = service.getAllTasks();

                if (tasks.isEmpty()) {
                    System.out.println("No tasks yet.");
                } else {
                    for (Task task : tasks){
                        System.out.println(task.getId() + ". " + task.getTitle()
                        + (task.isCompleted() ? "[DONE]" : "[UNDONE]"));
                    }
                }
            }

            case 3 -> {
                    tasks = service.getAllTasks();
                    if(tasks.isEmpty()){
                    System.out.println("No tasks to mark.");
                    break;
                }
                int idDone = readInt(scanner, "Enter task ID to mark done: ");
                if (service.markTaskCompleted(idDone)) {
                    System.out.println("Task marked as done!");
                } else {
                    System.out.println("Invalid task ID!");
                }
            }

            case 4 -> {
                tasks = service.getAllTasks();
                if(tasks.isEmpty()){
                    System.out.println("No tasks to delete.");
                    break;
                }
                int idDelete = readInt(scanner, "Enter task ID to delete: ");
                if (service.deleteTask(idDelete)) {
                    System.out.println("Task deleted");
                } else {
                    System.out.println("Invalid task ID!");
                }
            }

            case 5 -> {
                System.out.println("Goodbye!");
                scanner.close();
                return;
            }

            default -> System.out.println("Invalid choice! Please enter 1-5.");
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true){
            System.out.println(prompt);
            String input = scanner.nextLine();

            try{
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please try again!");
            }
        }
    }
}
