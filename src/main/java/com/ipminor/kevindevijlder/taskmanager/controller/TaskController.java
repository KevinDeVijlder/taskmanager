package com.ipminor.kevindevijlder.taskmanager.controller;

import com.ipminor.kevindevijlder.taskmanager.dto.SubTaskDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.User;
import com.ipminor.kevindevijlder.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//alles start bij /
@Controller
@RequestMapping("/")
public class TaskController {
    //service klasse die een repository bevat
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //navigatie naar taskovervieuw, met lijst van alle tasks
    @GetMapping("tasks")
    public String getTaskOverview(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "taskoverview";
    }

    //details krijge van 1 specifieke task
    @GetMapping("tasks/details/{taskId}")
    public String getTaskDetail(@PathVariable int taskId, Model model){
        model.addAttribute("task", taskService.getTask(taskId));
        if(taskService.getTask(taskId) != null) {
            if (taskService.getSubTasks(taskId).isEmpty() == false) {
                model.addAttribute("subtaskList", taskService.getSubTasks(taskId));
            }
        }
        return "taskdetails";
    }

    //navigatie form nieuwe task
    @GetMapping("tasks/new")
    public String getTaskForm(Model model){
        model.addAttribute("taskDTO", new TaskDTO());
        return "taskform";
    }

    //voegt nieuwe task toe indien deze geen errors heeft
    @PostMapping("tasks/createTask")
    public String PostNewTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "taskform";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }

    //navigatie formulier om nieuwe subtask aan task toe te voege
    @GetMapping("tasks/{taskId}/sub/create")
    public String getSubTaskForm(@PathVariable int taskId, Model model){
        model.addAttribute("masterTask", taskService.getTask(taskId));
        model.addAttribute("subTaskDTO", new SubTaskDTO());
        return "subtaskform";
    }

    //voegt nieuwe subtask toe aan mastertask indien deze geen errors heeft
    @PostMapping("tasks/sub/createTask")
    public String PostNewSubTask(@ModelAttribute @Valid SubTaskDTO subTaskDTO, BindingResult bindingResult, Model model, @RequestParam(value = "taskId") Integer taskId){
        if(bindingResult.hasErrors()){
            model.addAttribute("masterTask", taskService.getTask(taskId));
            return "subtaskform";
        }
        taskService.addSubTask(subTaskDTO, taskId);
        return "redirect:/tasks/details/" + taskId;
    }

    //Edit an existing task
    @GetMapping("tasks/edit/{taskId}")
    public String getEditTaskForm(@PathVariable int taskId, Model model){
        model.addAttribute("taskDTO", taskService.getTask(taskId));
        return "edittaskform";
    }

    @PostMapping("/tasks/edit")
    public String updateTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult, Model model, @RequestParam(value = "taskId") Integer taskId){
        if(bindingResult.hasErrors()){
            return "edittaskform";
        }
        taskService.editTask(taskDTO);
        return "redirect:/tasks/details/" + taskId;
    }

    //Alles over delete task

    @GetMapping("/tasks/delete/{taskId}")
    public String getDeleteTaskPage(@PathVariable int taskId, Model model){
        model.addAttribute("taskToDelete", taskService.getTask(taskId));
        return "deletetaskpage";
    }

    @PostMapping("/tasks/delete")
    public String postDeleteTask(@RequestParam(value = "confirmation") String confirmation, @RequestParam(value = "taskId") Integer taskId){
        if(confirmation.equals("yes")){
            taskService.removeTask(taskId);
        }
        return "redirect:/tasks";
    }

    //alles over deleteall

    @GetMapping("/tasks/deleteall")
    public String getDeleteAllTaskPage(Model model){
        model.addAttribute("amounttasktodelete", taskService.getTasks().size());
        return "deletealltaskpage";
    }

    @PostMapping("/tasks/deleteallconfirmed")
    public String postDeleteAllTask(@RequestParam(value = "confirmation") String confirmation){
        if(confirmation.equals("yes")){
            taskService.removeAllTasks();
        }
        return "redirect:/tasks";
    }


}