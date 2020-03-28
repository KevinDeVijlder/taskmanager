package com.ipminor.kevindevijlder.taskmanager;

import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.Task;
import com.ipminor.kevindevijlder.taskmanager.repository.TaskRepository;
import com.ipminor.kevindevijlder.taskmanager.service.TaskService;
import com.ipminor.kevindevijlder.taskmanager.service.TaskServiceImplementatie;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setup(){
        taskService.removeAllTasks();
    }


    //tests gettask
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
        assertTrue(listTasks.isEmpty());
        assertEquals(0, listTasks.size());;
    }

    // test addTask
    @Test
    public void testAddTask(){
        //setup

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskId(1);
        taskDTO.setTitle("opruimen kamer");
        taskDTO.setDescription("opruimen van de kamer en poetsen");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.of(2020, 03, 14, 18, 30));

        //methode dat we testen:
        taskService.addTask(taskDTO);

        List<Task> listTasks = taskService.getTasks();

        // checks
        assertNotNull(listTasks);
        assertFalse(listTasks.isEmpty());
        assertEquals(1, listTasks.size());
        Task testTask = listTasks.get(0);
        assertEquals("opruimen kamer", taskDTO.getTitle());
    }

    //test getTask
    @Test
    public void testgetTask(){
        //setup

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskId(1);
        taskDTO.setTitle("testtaak");
        taskDTO.setDescription("werken voor school");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.of(2020, 04, 15, 18, 30));

        taskService.addTask(taskDTO);

        //methode dat we testen:
        Task task = taskService.getTask(1);

        // checks
        assertNotNull(task);
        assertEquals("testtaak", task.getTitle());
    }

    @Test
    public void testgetTaskZonderTaskGeeftNull(){
        //methode dat we testen:
        Task task = taskService.getTask(1);

        // checks
        assertNull(task);
    }

    //test edittask
    /*@Test
    public void testEditTask(){
        //setup

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskId(2);
        taskDTO.setTitle("testtaak lang geneog");
        taskDTO.setDescription("werken voor schoolfdsfdsdsffds");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.of(2020, 5, 15, 18, 30));

        taskService.addTask(taskDTO);
        System.out.println(taskDTO.getTitle());
        System.out.println(taskService.getTasks().size());

        taskDTO.setTitle("aangepaste taak lang genoeg");
        System.out.println(taskDTO.getTaskId());
        System.out.println(taskDTO.getTitle());
        //methode dat we testen:
        taskService.editTask(taskDTO);

        // checks
        Task task = taskService.getTask(2);
        assertNotNull(task);
        assertEquals("aangepaste taak lang genoeg", task.getTitle());
    }*/

    //test removetask
    /*@Test
    public void testRemoveTask(){
        //setup

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskId(1);
        taskDTO.setTitle("testtaak lang geneog");
        taskDTO.setDescription("werken voor schoolfdsfdsdsffds");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.of(2020, 03, 15, 18, 30));

        taskService.addTask(taskDTO);

        List<Task> listTasks = taskService.getTasks();
        System.out.println(listTasks.get(0).getTaskId());
        Task task = taskService.getTask(1);

        //methode dat we testen
        taskService.removeTask(1);

        // checks
        assertTrue(taskService.getTasks().isEmpty());
    }*/

    //removealltask

    //test getsubtasks

    //test addsubtask

    //test getsubtask
}
