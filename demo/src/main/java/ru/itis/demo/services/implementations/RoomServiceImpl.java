package ru.itis.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.demo.dto.RoomDto;
import ru.itis.demo.models.Room;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.RoomRepository;
import ru.itis.demo.repositories.UsersRepositoryInterface;
import ru.itis.demo.security.details.UserDetailsImpl;
import ru.itis.demo.services.interfaces.RoomService;

import java.util.UUID;

public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UsersRepositoryInterface usersRepositoryInterface;
    @Override
    public Room createRoom(UserDetailsImpl userDetails, RoomDto roomDto) {
        UUID uuid = UUID.randomUUID();
        User user = usersRepositoryInterface.findByEmail(userDetails.getUsername()).get();
        Room room = Room.builder()
                .name(roomDto.getName())
                .ownerId(user.getId())
                .participants(roomDto.getParticipants())
                .build();
        roomRepository.save(room);
        return room;
    }
}
