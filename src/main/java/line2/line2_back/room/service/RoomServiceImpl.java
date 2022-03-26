package line2.line2_back.room.service;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.repository.HomeRepository;
import line2.line2_back.homeRoomTable.repository.HomeRoomTableRepository;
import line2.line2_back.room.model.Room;
import line2.line2_back.room.repository.RoomRepository;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final HomeRoomTableRepository homeRoomTableRepository;
    private final HomeRepository homeRepository;

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

    @Override
    public SystemMessage addHeadCount(Long id) {
        try {
            log.info("RoomService add headcount Room(id: {}) start", id);
            Room room = roomRepository.findById(id).get();
            if (room.getMaxHeadCount() > room.getHeadCount()) {
                Home home = homeRepository.findById(homeRoomTableRepository.findByRoomId(id).getHome().getId()).get();
                home.setHeadCount(home.getHeadCount() + 1);
                homeRepository.save(home);
                room.setHeadCount(room.getHeadCount() + 1);
                roomRepository.save(room);

                return SystemMessage.builder()
                        .code(1)
                        .message("인원 추가 성공")
                        .build();
            } else {
                return SystemMessage.builder()
                        .code(2)
                        .message("인원 추가 실패: 인원 가득 참")
                        .build();
            }

        } catch (Exception e) {
            log.error("RoomService add headcount Room failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(3)
                    .message("인원 추가 실패")
                    .build();
        } finally {
            log.info("RoomService add headcount Room end");
        }
    }

    @Override
    public SystemMessage subHeadCount(Long id) {
        try {
            log.info("RoomService sub headcount Room(id: {}) start", id);
            Room room = roomRepository.findById(id).get();
            if (room.getHeadCount() > 0) {
                Home home = homeRepository.findById(homeRoomTableRepository.findByRoomId(id).getHome().getId()).get();
                home.setHeadCount(home.getHeadCount() - 1);
                homeRepository.save(home);
                room.setHeadCount(room.getHeadCount() - 1);
                roomRepository.save(room);

                return SystemMessage.builder()
                        .code(1)
                        .message("인원 빼기 성공")
                        .build();
            } else {
                return SystemMessage.builder()
                        .code(2)
                        .message("인원 빼기 실패: 현재 인원이 0명 입니다.")
                        .build();
            }

        } catch (Exception e) {
            log.error("RoomService sub headcount Room failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(3)
                    .message("인원 빼기 실패")
                    .build();
        } finally {
            log.info("RoomService sub headcount Room end");
        }
    }
}
