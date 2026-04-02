package com.ivan.taskmanager.repository;

import com.ivan.taskmanager.database.DatabaseConnection;
import com.ivan.taskmanager.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public void save (Task task){
        String sql = "INSERT INTO tasks(title, completed) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, task.getTitle());
            statement.setBoolean(2, task.isCompleted());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error saving task", e);
        }
    }

    public List<Task> findAll(){
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks ORDER BY completed ASC, id ASC";

        try(Connection connection = DatabaseConnection.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                tasks.add(new Task(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getBoolean("completed")
                ));
            }
        } catch(SQLException e){
            throw new RuntimeException("Error fetching tasks", e);
        }
        return tasks;
    }

    public  boolean updateStatus(int id, boolean completed){
        String sql = "UPDATE tasks SET ocmpleted = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setBoolean(1, completed);
            statement.setInt(2, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating task", e);
        }
    }

    public  boolean deleteById(int id){
        String sql = "DELETE FROM taks WHERE id = ?";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting task", e);
        }
    }
}
