package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.Task;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String text;
    private String title;
    private String deadline;

    public static TaskDto from(Task task){
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .text(task.getText())
                .deadline(task.getDeadline())
                .build();
    }

}
