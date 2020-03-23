package com.ipminor.kevindevijlder.taskmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private long subtaskId;

    @NotEmpty(message = "Title can't be empty!")
    @Size(min = 5, max = 25, message = "Title has to be between 5 and 25 characters!")
    private String title;

    @NotEmpty(message = "Description can't be empty!")
    @Size(min = 10, max = 150, message = "Description has to be between 10 and 150 characters!")
    private String description;

    @ManyToOne
    private Task task;

    public SubTask(String title, String description) {
        this.setTitle(title);
        this.setDescription(description);
    }

    public SubTask(){

    }


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
