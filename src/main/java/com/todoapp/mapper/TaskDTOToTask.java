package com.todoapp.mapper;

import com.todoapp.entities.Task;
import com.todoapp.dto.TaskDTO;
import com.todoapp.entities.TaskStatus;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis.buelna
 */

@Component
public class TaskDTOToTask implements IMapper<TaskDTO, Task> {

    @Override
    public Task map(TaskDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }

}
