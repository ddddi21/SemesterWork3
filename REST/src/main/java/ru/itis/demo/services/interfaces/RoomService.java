package ru.itis.demo.services.interfaces;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import ru.itis.demo.dto.RoomDto;
import ru.itis.demo.models.Room;
import ru.itis.demo.security.details.UserDetailsImpl;

public interface RoomService {
    Room enterToRoom(@AuthenticationPrincipal UserDetailsImpl userDetails, RoomDto roomDto);
}
