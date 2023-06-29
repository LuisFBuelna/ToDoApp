package com.todoapp.repository;

import com.todoapp.entities.Task;
import com.todoapp.entities.TaskStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author luis.buelna
 */

public interface TaskRepository extends JpaRepository<Task, Long>{
    
    public List <Task> findAllByTaskStatus(TaskStatus taskStatus);
    
    @Modifying
    @Query(value = "UPDATE task SET finished = true WHERE id = :id", nativeQuery = true)
    public void markTaskFinished(@Param("id") Long id);
}
