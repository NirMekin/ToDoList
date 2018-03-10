package com.model;


import java.util.List;

/**
 * Created by tomerktzv on 25/02/2018.
 */
public interface IToDoListDAO {
    void register(Users user) throws exceptionsUsersTasks;
    List<Tasks> listOfTasks(int id);
    void editTask(String taskId, String taskName, String taskDesc, String taskCurrentStatus) throws exceptionsUsersTasks;
    void removeTask(String taskId) throws exceptionsUsersTasks;
    Users signIn(Users user) throws exceptionsUsersTasks;
}
