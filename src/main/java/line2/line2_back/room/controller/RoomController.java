package line2.line2_back.room.controller;

import line2.line2_back.room.model.Room;

public interface RoomController {
    Room add(Room room);

    Room edit(Room room);

    void delete(Long id);
}
