package ru.itis.demo.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.itis.demo.models.Task;
import ru.itis.demo.repositories.TasksRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    public List<Task> invalidTasks = new ArrayList<>();
    @Autowired
    private TasksRepository tasksRepository;

    @Scheduled(fixedRate = 600000)
    public void checkAvailableDeadline() throws ParseException {
        invalidTasks.clear();
        String currentDate = dateFormat.format(new Date());
        System.out.println("current date:" + currentDate);
        Date currentDateAtDate = dateFormat.parse(currentDate);
        System.out.println(tasksRepository.findAll());
        List<Task> allTasks = tasksRepository.findAll();
        for (Task task : allTasks) {
            task.setIsAvailable(true);
            String currentDeadline = task.getDeadline();
            Date checkingDate = dateFormat.parse(currentDeadline);
            if (currentDateAtDate.after(checkingDate)) {
                invalidTasks.add(task);
                task.setIsAvailable(false);
            }
        }
        System.out.println("invalid tasks size:" + invalidTasks.size());
    }
}
