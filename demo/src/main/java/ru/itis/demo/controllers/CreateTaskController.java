package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.TaskDto;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.implementations.CreateTaskServiceImpl;

@Controller
public class CreateTaskController {

    @Autowired
    private CreateTaskServiceImpl createTaskService;

    @GetMapping("/createTask")
    public String getCreateTaskPage(){
        return "create_task";
    }
    @PostMapping("/createTask")
    public String createTask(TaskDto form, @AuthenticationPrincipal UserDetailsImpl user, RedirectAttributes attributes){
        if(form.getText().isEmpty()){
            attributes.addFlashAttribute("error", "empty fields");
            return "redirect:/createTask";
        } else {
            if (createTaskService.addTask(form, user) != null) {
                attributes.addFlashAttribute("error", "success adding");
                return "redirect:/createTask";
            } else {
                attributes.addFlashAttribute("error", "something wrong");
                return "redirect:/createTask";
            }
        }

    }
}
