package com.todoapp.service;

import com.todoapp.dto.TaskDTO;
import com.todoapp.entities.Task;
import com.todoapp.entities.TaskStatus;
import com.todoapp.exceptions.ToDoExceptions;
import com.todoapp.mapper.TaskDTOToTask;
import com.todoapp.repository.TaskRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis.buelna
 */

@Service
public class TaskService {
    
    private final TaskRepository repository;
    
    @Autowired
    TaskDTOToTask mapper; 
    
    public TaskService(TaskRepository repository, TaskDTOToTask mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    
    public Task createTask(TaskDTO taskDTO){
        Task task = mapper.map(taskDTO);
        return this.repository.save(task);
    }
    
    public List <Task> findAll(){
        return repository.findAll();
    }
    
    public List <Task> findAllByTaskStatus(TaskStatus taskStatus){
        return repository.findAllByTaskStatus(taskStatus);
    }
    
    @Transactional
    public void updateTaskAsFinished (Long id){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        repository.markTaskFinished(id);
    }
    
    public void deleteById (Long id){
        Optional<Task> optionalTask = repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }
}
