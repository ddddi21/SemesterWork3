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
import ru.itis.demo.dto.TasksPageDto;
import ru.itis.demo.models.Task;
import ru.itis.demo.repositories.TasksRepository;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.implementations.AllTasksInterfaceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AllTasksController {

    @Autowired
    private AllTasksInterfaceImpl allTasks;

//    @PreAuthorize("isAuthenticated()")
//    @PostMapping("/tasks")
//    @ResponseBody
//    public String createTaskPage(@RequestBody TasksPageDto tasksPageDto) {
//        List<Task> tasks = allTasks.findAllTask(user);
//        StringBuilder allTasks= new StringBuilder();
//        for (Task task: tasks){
//            allTasks.append(task.getTitle()).append("#").append(task.getText()).append("#").append(task.getDeadline())
//                    .append("!");
//        }
//        response.getWriter().println(allTasks);
//        return "all_tasks";
//    }

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
