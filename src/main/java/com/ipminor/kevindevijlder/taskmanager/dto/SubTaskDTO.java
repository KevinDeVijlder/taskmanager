package com.ipminor.kevindevijlder.taskmanager.dto;

import com.ipminor.kevindevijlder.taskmanager.model.SubTask;
import com.ipminor.kevindevijlder.taskmanager.model.Task;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

public class SubTaskDTO {
    private long subtaskId;

    @NotEmpty(message = "Title can't be empty!")
    @Size.List({
            @Size(min = 5, message = "Title has to be at least 5 characters long"),
            @Size(max = 25, message = "Title can't be longer than 25 characters")
    })
    private String title;

    @NotEmpty(message = "Description can't be empty!")
    @Size.List({
            @Size(min = 10, message = "Description has to be at least 10 characters long"),
            @Size(max = 150, message = "Description can't be longer than 150 characters")
    })
    private String description;

    private Task task;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(long subtaskId) {
        this.subtaskId = subtaskId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}