package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.demo.dto.RoomDto;
import ru.itis.demo.models.Room;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.implementations.RoomServiceImpl;

@RestController
public class RoomController {
    @Autowired
    private RoomServiceImpl roomService;

    @GetMapping("/room")
    public String getRoom(@AuthenticationPrincipal UserDetailsImpl user, RedirectAttributes attributes, Model model, RoomDto roomDto){
        if(roomDto.getRoomId().isEmpty()){
            attributes.addFlashAttribute("error", "empty fields");
            return "redirect:/profile";
        } else {
            Room room = roomService.enterToRoom(user, roomDto);
            if (room != null) {
                model.addAttribute("roomId", room.getName());
                return "room_page";
            } else {
                attributes.addFlashAttribute("error", "room doesn't exist");
                return "redirect:/profile";
            }
        }
    }
}
