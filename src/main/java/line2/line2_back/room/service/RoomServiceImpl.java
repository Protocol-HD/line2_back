package line2.line2_back.room.service;

import line2.line2_back.room.model.Room;
import line2.line2_back.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;

    @Override
    public Room save(Room room) {
        try {
            log.info("RoomService save Room({}) start", room);
            return roomRepository.save(room);
        } catch (Exception e) {
            log.error("RoomService save Room failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("RoomService save Room end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("RoomService delete by id Room(id: {}) start", id);
            roomRepository.deleteById(id);
        } catch (Exception e) {
            log.error("RoomService delete by id Room failure, error: {}", e.getMessage());
        } finally {
            log.info("RoomService delete by id Room end");
        }
    }
}
