package ru.itis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.demo.models.Task;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TasksPageDto {
    private String taskName;
    private Integer pagesCount;
    private List<Task> papers;
}
