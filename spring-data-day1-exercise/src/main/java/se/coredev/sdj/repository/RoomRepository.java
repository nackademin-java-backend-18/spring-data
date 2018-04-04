package se.coredev.sdj.repository;

import org.springframework.data.repository.CrudRepository;
import se.coredev.sdj.repository.data.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
