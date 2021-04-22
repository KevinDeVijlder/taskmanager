package com.ipminor.kevindevijlder.taskmanager.repository;

import com.ipminor.kevindevijlder.taskmanager.model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}