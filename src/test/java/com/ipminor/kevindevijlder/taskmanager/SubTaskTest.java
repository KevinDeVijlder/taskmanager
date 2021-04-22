package com.ipminor.kevindevijlder.taskmanager;

import com.ipminor.kevindevijlder.taskmanager.dto.SubTaskDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import com.ipminor.kevindevijlder.taskmanager.model.Task;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubTaskTest {
    private Validator validator;

    @Test
    public void Correct_SubTask_Should_Have_No_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("test subtask title");
        subTaskDTO.setDescription("test subtask description");

        Set<ConstraintViolation<SubTaskDTO>> violations = validator.validate(subTaskDTO);
        assertTrue(violations.isEmpty());

    }

    @Test
    public void SubTask_With_empty_fields_Has_4_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("");
        subTaskDTO.setDescription("");

        Set<ConstraintViolation<SubTaskDTO>> violations = validator.validate(subTaskDTO);
        assertEquals(4, violations.size());

    }

    @Test
    public void SubTask_With_to_short_fields_Has_2_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("te");
        subTaskDTO.setDescription("te");

        Set<ConstraintViolation<SubTaskDTO>> violations = validator.validate(subTaskDTO);
        assertEquals(2, violations.size());

    }

    @Test
    public void SubTask_With_to_long_fields_Has_2_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        subTaskDTO.setDescription("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");

        Set<ConstraintViolation<SubTaskDTO>> violations = validator.validate(subTaskDTO);
        assertEquals(2, violations.size());

    }

    @Test
    public void SubTask_Getter_Test() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Task task = new Task();
        task.setTitle("task title");
        task.setDescription("a task description");
        task.setDateAndTimeOfTask(LocalDateTime.MIN);

        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("test subtask title");
        subTaskDTO.setDescription("test subtask description");
        subTaskDTO.setTask(task);

        Set<ConstraintViolation<SubTaskDTO>> violations = validator.validate(subTaskDTO);
        assertTrue(violations.isEmpty());
        assertEquals("test subtask title", subTaskDTO.getTitle());
        assertEquals("test subtask description", subTaskDTO.getDescription());
        assertEquals(task, subTaskDTO.getTask());
    }


}
