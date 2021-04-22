package com.ipminor.kevindevijlder.taskmanager.dto;

import com.ipminor.kevindevijlder.taskmanager.model.SubTask;
import org.hibernate.validator.constraints.LuhnCheck;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {
    private long taskId;

    @NotEmpty(message = "{task.title.notempty}")
    @Size.List({
            @Size(min = 5, message = "{task.title.size.min}"),
            @Size(max = 25, message = "{task.title.size.max}")
    })
    private String title;

    @NotEmpty(message = "{task.description.notempty}")
    @Size.List({
            @Size(min = 10, message = "{task.description.size.min}"),
            @Size(max = 150, message = "{task.description.size.max}")
    })
    private String description;

    @NotNull(message = "{task.date.notempty}")
    private LocalDateTime dateAndTimeOfTask;

    private List<SubTask> subTasks;


    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
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


    public LocalDateTime getDateAndTimeOfTask() {
        return dateAndTimeOfTask;
    }

    public void setDateAndTimeOfTask(LocalDateTime dateAndTimeOfTask) {
        this.dateAndTimeOfTask = dateAndTimeOfTask;
    }

    public List<SubTask> getSubTasks(){
        return this.subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks){
        this.subTasks = subTasks;
    }
}