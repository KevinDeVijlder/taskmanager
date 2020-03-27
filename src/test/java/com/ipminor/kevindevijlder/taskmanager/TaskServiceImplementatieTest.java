package com.ipminor.kevindevijlder.taskmanager;

import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.Task;
import com.ipminor.kevindevijlder.taskmanager.repository.TaskRepository;
import com.ipminor.kevindevijlder.taskmanager.service.TaskService;
import com.ipminor.kevindevijlder.taskmanager.service.TaskServiceImplementatie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TaskServiceImplementatieTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void testGetTasksMetEenTask(){
        //setup

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskId(1);
        taskDTO.setTitle("opruimen kamer");
        taskDTO.setDescription("opruimen van de kamer en poetsen");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.of(2020, 03, 14, 18, 30));

        taskService.addTask(taskDTO);

        //methode dat we testen:
        List<Task> listTasks = taskService.getTasks();

        // checks
        assertNotNull(listTasks);
        assertFalse(listTasks.isEmpty());
        assertEquals(1, listTasks.size());
        Task testTask = listTasks.get(0);
        assertNotNull(testTask);

    }

    @Test
    public void testGetTasksZonderTask(){
        //methode dat we testen:
        List<Task> listTasks = taskService.getTasks();

        // checks
        assertEquals(0, listTasks.size());;
    }
}
