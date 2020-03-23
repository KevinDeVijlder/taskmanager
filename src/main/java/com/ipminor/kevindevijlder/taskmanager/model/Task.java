package com.ipminor.kevindevijlder.taskmanager.model;

import com.ipminor.kevindevijlder.taskmanager.dto.SubTaskDTO;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private long taskId;

    @NotEmpty(message = "Title can't be empty!")
    @Size(min = 5, max = 25, message = "Title has to be between 5 and 25 characters!")
    private String title;

    @NotEmpty(message = "Description can't be empty!")
    @Size(min = 10, max = 150, message = "Description has to be between 10 and 150 characters!")
    private String description;

    @NotNull(message = "Date can't be empty!")
    private LocalDateTime dateAndTimeOfTask;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<SubTask> subTasks;

    public Task(){

    }

    public Task(long taskId, String title, String description, LocalDateTime dateAndTimeOfTask) {
        this.setTaskId(taskId);
        this.setTitle(title);
        this.setDescription(description);
        this.setDateAndTimeOfTask(dateAndTimeOfTask);
        subTasks = new ArrayList<>();
    }

    public Task(long taskId, String title, String description, LocalDateTime dateAndTimeOfTask, List<SubTask> subTasks){
        this.setTaskId(taskId);
        this.setTitle(title);
        this.setDescription(description);
        this.setDateAndTimeOfTask(dateAndTimeOfTask);
        this.setSubTasks(subTasks);
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

    public void setSubTasks(List<SubTask> subTasks){
        this.subTasks = subTasks;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
}