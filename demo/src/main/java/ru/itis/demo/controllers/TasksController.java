package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.TaskDto;
import ru.itis.demo.dto.TaskForSmsDto;
import ru.itis.demo.helpers.ScheduledTasks;
import ru.itis.demo.models.Task;
import ru.itis.demo.models.User;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.implementations.SmsServiceImpl;
import ru.itis.demo.services.implementations.TasksInterfaceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TasksController {

    @Autowired
    private TasksInterfaceImpl tasksService;

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Autowired
    private SmsServiceImpl smsService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tasks/{user}")
    public String editTask(@PathVariable User user,
                           Model model,
                           @RequestParam(required = false) Task task) {
        model.addAttribute("message", task);
        return "edit_task";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tasks/{user}/delete")
    public String deleteTask(
            @AuthenticationPrincipal UserDetailsImpl currentUser,
            @PathVariable Long user,
            @RequestParam(required = false) Task task,
            RedirectAttributes attributes
    ) {
        tasksService.deleteTask(currentUser,task);
        attributes.addFlashAttribute("error", "success delete!");
        return "redirect:/tasks";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/tasks/{user}")
    public String updateTask(
            @AuthenticationPrincipal UserDetailsImpl currentUser,
            @PathVariable Long user,
            @RequestParam("task") Task task,
            @RequestParam("text") String text,
            @RequestParam("title") String title,
            @RequestParam("deadline") String deadline,
            RedirectAttributes attributes
    ) {
        task.setDeadline(deadline);
        task.setText(text);
        task.setTitle(title);
        tasksService.editTask(currentUser, TaskDto.from(task));
        attributes.addFlashAttribute("error", "success edit!");
        return "redirect:/tasks";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tasks")
    public String getCreateTaskPage(@RequestParam(required = false, defaultValue = "") String filter,
                                      Model model,
                                      @AuthenticationPrincipal UserDetailsImpl userDetails,
                                      @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable){

        Page<Task> page;

        if (filter != null && !filter.isEmpty()) {
            page = tasksService.findAllByOwnerIdAndTitle(userDetails,filter, pageable);
        } else {
            page = tasksService.findAllTask(userDetails,pageable);
        }
        List<Task> invalidTasks = scheduledTasks.invalidTasks;
        List<Task> myInvalidTasks = new ArrayList<>();
        List <TaskForSmsDto>taskForSms = new ArrayList<>();
        for(Task task: invalidTasks){
            if(task.getOwnerId().equals(userDetails.getUserId())){
                myInvalidTasks.add(task);
                System.out.println("task.setIsSmsAboutInvalidSend before:" + task.getIsSmsAboutInvalidSend());
               if(task.getIsSmsAboutInvalidSend() == null || !task.getIsSmsAboutInvalidSend()){
                   taskForSms.add(TaskForSmsDto.from(task));
                   task.setIsSmsAboutInvalidSend(true);
                   tasksService.save(task);
                   System.out.println("task.setIsSmsAboutInvalidSend after:" + task.getIsSmsAboutInvalidSend());
               }
            }
        }
        System.out.println("taskForSms:" + taskForSms.toString());
        if(!taskForSms.isEmpty()) {
//            smsService.sendSms(userDetails.getUserPhone(), "These tasks have expired:\n" + taskForSms.toString());
        }
        model.addAttribute("page", page);
        model.addAttribute("url", "/tasks");
        model.addAttribute("filter", filter);
        return "tasks";
    }
}
