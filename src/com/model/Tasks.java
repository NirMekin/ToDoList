package com.model;

/**
 * Created by tomerktzv on 25/02/2018.
 */
public class Tasks {
    private int taskId;
    private int userId;
    private String taskName;
    private String description;
    private String taskCurrentStatus;

    public Tasks() {

    }

    public Tasks(int taskId, int userId, String taskName, String desc, String taskCurrentStatus) {
        this.taskId = taskId;
        this.userId = userId;
        this.taskName = taskName;
        this.description = description;
        this.taskCurrentStatus = taskCurrentStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskCurrentStatus() {
        return taskCurrentStatus;
    }

    public void setTaskCurrentStatus(String taskCurrentStatus) {
        this.taskCurrentStatus = taskCurrentStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task #" + this.taskId + ", Name: " + this.taskName + ", description: " + this.description + ", current status: " + this.taskCurrentStatus + "!";
    }
}
