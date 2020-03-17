package com.ipminor.kevindevijlder.taskmanager.repository;

import com.ipminor.kevindevijlder.taskmanager.model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    Optional<Task> findById(Long taskId);

    @Override
    List<Task> findAll();

    @Override
    <S extends Task> S save(S s);

}