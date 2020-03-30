package com.ipminor.kevindevijlder.taskmanager.service;

import com.ipminor.kevindevijlder.taskmanager.dto.SubTaskDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.SubTask;
import com.ipminor.kevindevijlder.taskmanager.model.Task;
import com.ipminor.kevindevijlder.taskmanager.repository.SubTaskRepository;
import com.ipminor.kevindevijlder.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImplementatie implements TaskService{
    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;

    @Autowired
    public TaskServiceImplementatie(TaskRepository taskRepository, SubTaskRepository subTaskRepository) {
        this.taskRepository = taskRepository;
        this.subTaskRepository = subTaskRepository;
    }

    @Override
    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public TaskDTO addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTaskId(taskDTO.getTaskId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDateAndTimeOfTask(taskDTO.getDateAndTimeOfTask());
        task.setSubTasks(taskDTO.getSubTasks());
        task = taskRepository.save(task);
        return convert(task);
    }

    @Override
    public TaskDTO getTask(long taskId) {
        return convert(taskRepository.findById(taskId).orElse(null));
    }

    @Override
    public TaskDTO editTask(TaskDTO taskDTO) {
        Task task = taskRepository.findById(taskDTO.getTaskId()).orElse(null);

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDateAndTimeOfTask(taskDTO.getDateAndTimeOfTask());

        task = taskRepository.save(task);
        return convert(task);
    }

    @Override
    public void removeTask(long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void removeAllTasks() {
        taskRepository.deleteAll();
    }

    //subtask stuff

    @Override
    public List<SubTask> getSubTasks(long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task == null){
            return null;
        } else {
            return task.getSubTasks();
        }
    }

    @Override
    public void addSubTask(SubTaskDTO subTaskDTO, long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task != null) {
            task.AddSubTask(subTaskDTO);
            taskRepository.saveAndFlush(task);
        }
    }

    //converter

    private TaskDTO convert(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        if (task != null) {
            taskDTO.setTaskId(task.getTaskId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setDateAndTimeOfTask(task.getDateAndTimeOfTask());
            taskDTO.setSubTasks(task.getSubTasks());
            return taskDTO;
        } else {
            return null;
        }
    }


}
