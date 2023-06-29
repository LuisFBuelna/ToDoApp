package com.todoapp.dto;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author luis.buelna
 */

@Data
public class TaskDTO {
    
    private String title;
    private String description; 
    private LocalDateTime eta;
}
