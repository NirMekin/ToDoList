package com.model;


import java.util.List;

/**
 * Created by tomerktzv on 25/02/2018.
 */
public interface IToDoListDAO {
    public void createUser(Users user) throws exceptionsUsersTasks;
    public List<Tasks> listOfTasks(int id);
    public void editTask(int taskId) throws exceptionsUsersTasks;
    public void removeTask(int taskId) throws exceptionsUsersTasks;
}
