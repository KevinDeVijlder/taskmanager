package com.ipminor.kevindevijlder.taskmanager.service;

import com.ipminor.kevindevijlder.taskmanager.dto.SubTaskDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.SubTask;
import com.ipminor.kevindevijlder.taskmanager.model.Task;

import java.util.HashMap;
import java.util.List;

public interface TaskService {
    public List<TaskDTO> getTasks();

    public TaskDTO addTask(TaskDTO taskDTO);

    public TaskDTO getTask(long taskId);

    public TaskDTO editTask(TaskDTO taskDTO);

    public void removeTask(long taskId);

    public void removeAllTasks();

    //subtask alles

    public List<SubTask> getSubTasks(long taskId);

    public void addSubTask(SubTaskDTO subTaskDTO, long taskId);


}
