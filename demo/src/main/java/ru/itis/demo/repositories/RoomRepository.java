package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.Room;

@Repository("roomRepository")
public interface RoomRepository extends JpaRepository<Room,Long> {
}
