package com.ipminor.kevindevijlder.taskmanager.rest;

import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.service.TaskService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestTaskController {
    private final TaskService taskService;

    public RestTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{taskId}")
    @ResponseBody
    public TaskDTO getTask(@PathVariable Long taskId) {
        return taskService.getTask(taskId);
    }


    @PostMapping("/tasks")
    public TaskDTO createNewHead(@RequestBody @Valid TaskDTO taskDTO){
        return taskService.addTask(taskDTO);
    }

    @PutMapping("/tasks")
    public TaskDTO editTask(@RequestBody @Valid TaskDTO taskDTO){
        return taskService.editTask(taskDTO);
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.removeTask(taskId);
    }

}
