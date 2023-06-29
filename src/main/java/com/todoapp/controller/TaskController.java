package com.todoapp.controller;

import com.todoapp.dto.TaskDTO;
import com.todoapp.entities.Task;
import com.todoapp.entities.TaskStatus;
import com.todoapp.service.TaskService;
import java.net.http.HttpResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis.buelna
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @PostMapping("/create")
    public Task createTask(@RequestBody TaskDTO taskDTO){
        return this.taskService.createTask(taskDTO);
    }
    
    @GetMapping
    public List <Task> findAll(){
        return taskService.findAll();
    }
    
    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status){
        return taskService.findAllByTaskStatus(status);
    }
    
    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity <Void> markAsFinished(@PathVariable("id") Long id){
        taskService.updateTaskAsFinished(id);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
