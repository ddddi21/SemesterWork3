package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Room> getRoom(@RequestBody RoomDto roomDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl user = (UserDetailsImpl) authentication.getDetails();
        return ResponseEntity.ok(roomService.enterToRoom(user, roomDto));
    }
}
