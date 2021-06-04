package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import ru.itis.demo.dto.RoomDto;
import ru.itis.demo.models.Room;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.RoomRepository;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.interfaces.RoomService;

import java.util.UUID;

@Component
public class RoomServiceImpl implements RoomService {

    @Qualifier("roomRepository")
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;
    @Override
    public Room enterToRoom(@AuthenticationPrincipal UserDetailsImpl userDetails, RoomDto roomDto) {
        Room room = roomRepository.findByKey(roomDto.getRoomId());
        if (room != null){
            User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
            user.setRoomId(roomDto.getRoomId());
            usersRepositoryInterface.save(user);
            return room;
        } else return null;
    }
}
