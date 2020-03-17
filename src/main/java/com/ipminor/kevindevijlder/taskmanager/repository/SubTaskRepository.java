package com.ipminor.kevindevijlder.taskmanager.repository;

import com.ipminor.kevindevijlder.taskmanager.model.SubTask;
import com.ipminor.kevindevijlder.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubTaskRepository  extends JpaRepository<SubTask, Long> {

    @Override
    Optional<SubTask> findById(Long taskId);

    @Override
    List<SubTask> findAll();

    @Override
    <S extends SubTask> S save(S s);
}
