package line2.line2_back.room.controller;

import line2.line2_back.room.model.Room;
import line2.line2_back.room.service.RoomService;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class RoomControllerImpl implements RoomController{
    private final RoomService roomService;

    @Override
    @PostMapping("/v1/room")
    public Room add(@RequestBody Room room) {
        try {
            log.info("RoomController add Room({}) start", room);
            return roomService.save(room);
        } catch (Exception e) {
            log.error("RoomController add Room failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("RoomController add Room end");
        }
    }

    @Override
    @PutMapping("/v1/room")
    public Room edit(@RequestBody Room room) {
        try {
            log.info("RoomController edit Room({}) start", room);
            return roomService.save(room);
        } catch (Exception e) {
            log.error("RoomController edit Room failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("RoomController edit Room end");
        }
    }

    @Override
    @DeleteMapping("/v1/room/{id}")
    public void delete(@PathVariable Long id) {
        try {
            log.info("RoomController delete by id Room(id: {}) start", id);
            roomService.deleteById(id);
        } catch (Exception e) {
            log.error("RoomController delete by id Room failure, error: {}", e.getMessage());
        } finally {
            log.info("RoomController delete by id Room end");
        }
    }

    @Override
    @PutMapping("/v1/room/add_head_count/{id}")
    public SystemMessage addHeadCount(@PathVariable Long id) {
        try {
            log.info("RoomController add headcount Room(id: {}) start", id);
            return roomService.addHeadCount(id);
        } catch (Exception e) {
            log.error("RoomController add headcount Room failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(3)
                    .message("인원 추가 실패")
                    .build();
        } finally {
            log.info("RoomController add headcount Room end");
        }
    }

    @Override
    @PutMapping("/v1/room/sub_head_count/{id}")
    public SystemMessage subHeadCount(@PathVariable Long id) {
        try {
            log.info("RoomController sub headcount Room(id: {}) start", id);
            return roomService.subHeadCount(id);
        } catch (Exception e) {
            log.error("RoomController sub headcount Room failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(3)
                    .message("인원 빼기 실패")
                    .build();
        } finally {
            log.info("RoomController sub headcount Room end");
        }
    }
}
