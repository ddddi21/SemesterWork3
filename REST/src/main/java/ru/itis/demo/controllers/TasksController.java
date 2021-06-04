package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.TaskDto;
import ru.itis.demo.dto.TaskForSmsDto;
import ru.itis.demo.helpers.ScheduledTasks;
import ru.itis.demo.models.Task;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.implementations.SmsServiceImpl;
import ru.itis.demo.services.implementations.TasksInterfaceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TasksController {

    @Autowired
    private TasksInterfaceImpl tasksService;

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Autowired
    private SmsServiceImpl smsService;


    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/tasks/{user}/delete")
    public ResponseEntity<TaskDto> deleteTask(
            @PathVariable Long user,
            @RequestParam(required = false) Task task
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getDetails();
        tasksService.deleteTask(currentUser,task);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable("id") Long id,
            @RequestParam("text") String text,
            @RequestParam("title") String title,
            @RequestParam("deadline") String deadline) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getDetails();
        Task task = new Task();
        task.setId(id);
        task.setDeadline(deadline);
        task.setText(text);
        task.setTitle(title);
        return ResponseEntity.ok(tasksService.editTask(currentUser, TaskDto.from(task)));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tasks")
    public List<Task> tasks(){

        List<Task> page;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getDetails();

//        if (filter != null && !filter.isEmpty()) {
//            page = allTasks.findAllByOwnerIdAndTitle(userDetails,filter);
//        } else {
            page = tasksService.findAllTask(userDetails);
//        }
        List<Task> invalidTasks = scheduledTasks.invalidTasks;
        List<Task> myInvalidTasks = new ArrayList<>();
        List <TaskForSmsDto>taskForSms = new ArrayList<>();
        for(Task task: invalidTasks){
            if(task.getOwnerId().equals(userDetails.getUserId())){
                myInvalidTasks.add(task);
               if(task.getIsSmsAboutInvalidSend() == null || !task.getIsSmsAboutInvalidSend()){
                   taskForSms.add(TaskForSmsDto.from(task));
                   task.setIsSmsAboutInvalidSend(true);
               }
            }
        }
        if(!taskForSms.isEmpty()) {
//            smsService.sendSms(userDetails.getUserPhone(), "These tasks have expired:\n" + taskForSms.toString());
        }
        return page;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/addTask")
    public ResponseEntity<Task> addTask(@RequestBody TaskDto form){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl user = (UserDetailsImpl) authentication.getDetails();
        Task task = new Task();
        if(form.getText().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            task = tasksService.addTask(form, user);
            return ResponseEntity.ok(task);
        }
    }
}
