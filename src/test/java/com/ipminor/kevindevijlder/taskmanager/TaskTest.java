package com.ipminor.kevindevijlder.taskmanager;

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
import java.util.Set;

import org.junit.Before;

@SpringBootTest
public class TaskTest {
 /*   private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void Correct_Task_Should_Have_No_Violations() {
        //given:
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("een");
        taskDTO.setDescription("een beschrijving die lang is");
        taskDTO.setDateAndTimeOfTask(LocalDateTime.MIN);

        //when:
        Set<ConstraintViolation<TaskDTO>> violations = validator.validate(taskDTO);
        assertFalse(violations.isEmpty());

        //then:
    }*/


}
