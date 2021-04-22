package com.ipminor.kevindevijlder.taskmanager;

import com.ipminor.kevindevijlder.taskmanager.dto.SubTaskDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.Task;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;

@SpringBootTest
public class TaskTest {
    private Validator validator;

    @Test
    public void Correct_Task_Should_Have_No_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("lang genoege titel");
        taskDTO.setDescription("een beschrijving die lang is");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertTrue(violations.isEmpty());

    }

    @Test
    public void Task_With_Too_Short_Title_Has_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("sho");
        taskDTO.setDescription("een beschrijving die lang is");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());

    }

    @Test
    public void Task_With_empty_Title_Has_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("");
        taskDTO.setDescription("een beschrijving die lang is");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
    }

    @Test
    public void Task_With_Long_Title_Has_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("12345678911234567892123456");
        taskDTO.setDescription("een beschrijving die lang is");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void Task_With_Too_Short_Description_Has_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("titel");
        taskDTO.setDescription("so");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void Task_With_Too_long_Description_Has_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("titel");
        taskDTO.setDescription("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void Task_With_No_Description_Has_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("titel");
        taskDTO.setDescription("");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
    }

    @Test
    public void Task_With_No_Date_Has_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("titel");
        taskDTO.setDescription("a long enough dexcription for sure");
        taskDTO.setDateAndTimeOfTask(null);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    public void Task_With_No_Title_and_No_Description_And_No_Date_Has_Multiple_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("");
        taskDTO.setDescription("");
        taskDTO.setDateAndTimeOfTask(null);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());
        assertEquals(5, violations.size());
    }

    @Test
    public void Task_Getters_Test() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("titel");
        taskDTO.setDescription("a description thats long enough");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertTrue(violations.isEmpty());
        assertEquals("titel", taskDTO.getTitle());
        assertEquals("a description thats long enough", taskDTO.getDescription());
        assertEquals(LocalDateTime.MIN, taskDTO.getDateAndTimeOfTask());
    }

    @Test
    public void Task_Set_And_get_Subtasks_Returns_SubTasks() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("titel");
        taskDTO.setDescription("a long enough description");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("subtask title");
        subTaskDTO.setDescription("subtask long enough description");

        List list = new ArrayList<>();
        list.add(subTaskDTO);

        taskDTO.setSubTasks(list);

        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertTrue(violations.isEmpty());
        assertEquals(1, taskDTO.getSubTasks().size());
    }

}
