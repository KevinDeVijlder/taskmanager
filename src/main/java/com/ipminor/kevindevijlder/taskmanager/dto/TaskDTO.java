package com.ipminor.kevindevijlder.taskmanager.dto;

import com.ipminor.kevindevijlder.taskmanager.model.SubTask;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {
    private long taskId;

    @NotEmpty(message = "Title can't be empty!")
    @Size(min = 5, max = 25, message = "Title has to be between 5 and 25 characters!")
    private String title;

    @NotEmpty(message = "Description can't be empty!")
    @Size(min = 10, max = 150, message = "Description has to be between 10 and 150 characters!")
    private String description;

    @NotNull(message = "Date can't be empty!")
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

    public void AddSubTask(@Valid SubTaskDTO subTaskDTO){
        SubTask subTask = new SubTask(subTaskDTO.getTitle(), subTaskDTO.getDescription());
        subTasks.add(subTask);
    }

    public void AddSubTaskZonderDTO(SubTask subTask){
        subTasks.add(subTask);
    }

    public List<SubTask> getSubTasks(){
        return this.subTasks;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks){
        this.subTasks = subTasks;
    }
}