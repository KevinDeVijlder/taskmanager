package com.ipminor.kevindevijlder.taskmanager.service;

import com.ipminor.kevindevijlder.taskmanager.dto.SubTaskDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.SubTask;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();

    TaskDTO addTask(TaskDTO taskDTO);

    TaskDTO getTask(long taskId);

    TaskDTO editTask(TaskDTO taskDTO);

    void removeTask(long taskId);

    void removeAllTasks();

    //subtask alles

    List<SubTask> getSubTasks(long taskId);

    void addSubTask(SubTaskDTO subTaskDTO, long taskId);


}
