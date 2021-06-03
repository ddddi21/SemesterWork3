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
public class TaskForSmsDto {
    private String text;
    private String title;
    private String deadline;

    public static TaskForSmsDto from(Task task){
        return TaskForSmsDto.builder()
                .title(task.getTitle())
                .text(task.getText())
                .deadline(task.getDeadline())
                .build();
    }

    @Override
    public String toString(){
        return "Tag: " + title + "\nText: " + text + "\nDeadline: " + deadline + "\n";
    }
}
