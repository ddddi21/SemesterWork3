package ru.itis.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.services.interfaces.ConfirmationService;

import javax.annotation.security.PermitAll;

@Controller
@RequestMapping("/confirm")
@RequiredArgsConstructor
public class ConfirmationController {
    private final ConfirmationService confirmationService;

    @PermitAll
    @GetMapping("/{key}")
    public String confirmAccount(@PathVariable(name = "key") String code,
                                 RedirectAttributes redirectAttributes) {
        boolean confirmationResult = confirmationService.confirmByCode(code);
        String redirectUrl = "redirect:/signIn";
        String infoMessage = confirmationResult ? "Successfully confirmed" : "Code not found";
        redirectAttributes.addFlashAttribute("info", infoMessage);
        return redirectUrl;
    }
}
