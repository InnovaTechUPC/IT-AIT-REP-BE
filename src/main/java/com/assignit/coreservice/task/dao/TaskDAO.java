package com.assignit.coreservice.task.dao;

import com.assignit.coreservice.task.model.Task;
import com.assignit.coreservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskDAO extends JpaRepository<Task, Long> {
    List<Task> findTasksByProjectId(Long idProject);

    @Query(value = "SELECT u.user FROM Task u WHERE u.project.id = :projectId")
    List<User> findUsersByProjectId(@Param("projectId") Long ProjectId);

}
