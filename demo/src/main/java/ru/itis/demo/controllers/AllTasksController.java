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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.TaskDto;
import ru.itis.demo.dto.TasksPageDto;
import ru.itis.demo.models.Task;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.TasksRepository;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.implementations.AllTasksInterfaceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
public class AllTasksController {

    @Autowired
    private AllTasksInterfaceImpl allTasks;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/tasks/{user}")
    public String createTaskPage(  @PathVariable User user,
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
            @RequestParam("task") Task task,
            RedirectAttributes attributes
    ) {
        allTasks.deleteTask(currentUser,task);
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
        allTasks.editTask(currentUser, TaskDto.from(task));
        attributes.addFlashAttribute("error", "success edit!");
        return "redirect:/tasks";
    }

    @GetMapping("/tasks")
    public String getCreateTaskPage(@RequestParam(required = false, defaultValue = "") String filter,
                                      Model model,
                                      @AuthenticationPrincipal UserDetailsImpl userDetails,
                                      @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable){

        Page<Task> page;

        if (filter != null && !filter.isEmpty()) {
            page = allTasks.findAllByOwnerIdAndTitle(userDetails,filter, pageable);
        } else {
            page = allTasks.findAllTask(userDetails,pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("url", "/tasks");
        model.addAttribute("filter", filter);
        return "all_tasks";
    }
}
