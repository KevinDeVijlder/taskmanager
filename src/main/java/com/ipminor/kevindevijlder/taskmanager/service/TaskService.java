package com.ipminor.kevindevijlder.taskmanager.service;

import com.ipminor.kevindevijlder.taskmanager.dto.SubTaskDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.SubTask;
import com.ipminor.kevindevijlder.taskmanager.model.Task;

import java.util.HashMap;
import java.util.List;

public interface TaskService {
    public List<Task> getTasks();

    public void addTask(TaskDTO taskDTO);

    public Task getTask(long taskId);

    public void editTask(TaskDTO taskDTO);

    //subtask alles

    public List<SubTask> getSubTasks(long taskId);

    public void addSubTask(SubTaskDTO subTaskDTO, long taskId);

    public SubTask getSubTask(long subtaskId);

}
