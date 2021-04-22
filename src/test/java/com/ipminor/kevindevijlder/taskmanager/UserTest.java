package com.ipminor.kevindevijlder.taskmanager;

import com.ipminor.kevindevijlder.taskmanager.dto.CreateUserDTO;
import com.ipminor.kevindevijlder.taskmanager.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserTest {
    private Validator validator;

    @Test
    public void Correct_User_Should_Have_No_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

       CreateUserDTO createUserDTO = new CreateUserDTO();
       createUserDTO.setUsername("Testuser");
       createUserDTO.setFullname("Test user");
       createUserDTO.setEmail("Test@test.be");
       createUserDTO.setPassword("testpassword");
       createUserDTO.setPasswordconfirmed("testpassword");

        Set<ConstraintViolation<CreateUserDTO>> violations = validator.validate(createUserDTO);
        assertTrue(violations.isEmpty());

    }

    @Test
    public void All_empty_fields_User_Should_Have_nine_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername(""); //2
        createUserDTO.setFullname(""); //2
        createUserDTO.setEmail(""); //1
        createUserDTO.setPassword(""); //2
        createUserDTO.setPasswordconfirmed(""); //2

        Set<ConstraintViolation<CreateUserDTO>> violations = validator.validate(createUserDTO);
        assertEquals(9, violations.size());



    }

    @Test
    public void All_fields_to_short_Should_Have_five_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername("te"); //2
        createUserDTO.setFullname("te"); //2
        createUserDTO.setEmail("te"); //1
        createUserDTO.setPassword("te"); //2
        createUserDTO.setPasswordconfirmed("te"); //2

        Set<ConstraintViolation<CreateUserDTO>> violations = validator.validate(createUserDTO);
        assertEquals(5, violations.size());
    }

    @Test
    public void All_fields_to_long_Should_Have_five_Violations() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"); //2
        createUserDTO.setFullname("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"); //2
        createUserDTO.setEmail("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"); //1
        createUserDTO.setPassword("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"); //2
        createUserDTO.setPasswordconfirmed("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"); //2

        Set<ConstraintViolation<CreateUserDTO>> violations = validator.validate(createUserDTO);
        assertEquals(5, violations.size());
    }

    @Test
    public void Passwords_fields_not_equal_Should_Have_one_Violation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername("Testuser2");
        createUserDTO.setFullname("Test user");
        createUserDTO.setEmail("Test@test.be");
        createUserDTO.setPassword("testpassword");
        createUserDTO.setPasswordconfirmed("passwordtest");

        Set<ConstraintViolation<CreateUserDTO>> violations = validator.validate(createUserDTO);
        assertEquals(1, violations.size());
    }

    @Test
    public void User_Getters_Work() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername("Testuser3");
        createUserDTO.setFullname("Test user");
        createUserDTO.setEmail("Test@test.be");
        createUserDTO.setPassword("testpassword");
        createUserDTO.setPasswordconfirmed("testpassword");

        Set<ConstraintViolation<CreateUserDTO>> violations = validator.validate(createUserDTO);
        assertTrue(violations.isEmpty());
        assertEquals("Testuser3", createUserDTO.getUsername());
        assertEquals("Test user", createUserDTO.getFullname());
        assertEquals("Test@test.be", createUserDTO.getEmail());
        assertEquals("testpassword", createUserDTO.getPassword());
        assertEquals("testpassword", createUserDTO.getPasswordconfirmed());
    }


}
