package line2.line2_back.room.service;

import line2.line2_back.room.model.Room;

public interface RoomService {
    Room save(Room room);

    void deleteById(Long id);
}