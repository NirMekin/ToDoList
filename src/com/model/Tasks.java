package com.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;

public class Tasks {

    @Id
    @GeneratedValue
    private int taskId;
    private int userId;
    private String taskName;
    private String description;
    private String taskCurrentStatus;

    public Tasks() {
        setTaskId(new Random().nextInt() & Integer.MAX_VALUE);
        setTaskCurrentStatus("Not Started");
    }

    public Tasks(int userId, String taskName, String desc) {
        setTaskId(new Random().nextInt() & Integer.MAX_VALUE);
        setUserId(userId);
        setTaskName(taskName);
        setDescription(desc);
        setTaskCurrentStatus("Not Started");
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        if (taskName.equals("")) return;
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.equals("")) return;
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
        if (taskCurrentStatus.equals("")) return;
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
