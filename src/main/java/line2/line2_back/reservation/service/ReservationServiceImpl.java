package line2.line2_back.reservation.service;

import line2.line2_back.home.repository.HomeRepository;
import line2.line2_back.reservation.model.*;
import line2.line2_back.reservation.repository.ReservationRepository;
import line2.line2_back.room.repository.RoomRepository;
import line2.line2_back.systemMessage.SystemMessage;
import line2.line2_back.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final HomeRepository homeRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Override
    public SystemMessage add(ReservationDto reservationDto) {
        try {
            log.info("ReservationService add Reservation({}) start", reservationDto);
            if (
                    reservationRepository.findByRoomIdAndCheckOutGreaterThanAndCheckInLessThan(
                            reservationDto.getRoomId(),
                            reservationDto.getCheckIn(),
                            reservationDto.getCheckOut()
                    ).size() < roomRepository.findById(reservationDto.getRoomId()).get().getMaxHeadCount()
            ) {
                reservationRepository.save(Reservation.builder()
                        .id(reservationDto.getReservationId())
                        .home(homeRepository.findById(reservationDto.getHomeId()).get())
                        .room(roomRepository.findById(reservationDto.getRoomId()).get())
                        .user(userRepository.findById(reservationDto.getUserId()).get())
                        .checkIn(reservationDto.getCheckIn())
                        .checkOut(reservationDto.getCheckOut())
                        .hostToGuest(reservationDto.getGuestToHost())
                        .build());
                return SystemMessage.builder()
                        .code(1)
                        .message("예약 성공")
                        .build();
            } else {
                return SystemMessage.builder()
                        .code(3)
                        .message("예약 실패: 인원 초과")
                        .build();
            }

        } catch (Exception e) {
            log.error("ReservationService add Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 실패")
                    .build();
        } finally {
            log.info("ReservationService add Reservation end");
        }
    }

    @Override
    public SystemMessage edit(ReservationChangeDateDtoInput reservationChangeDateDtoInput) {
        try {
            log.info("ReservationService edit Reservation({}) start", reservationChangeDateDtoInput);
            Long roomId = reservationRepository.findById(reservationChangeDateDtoInput.getReservationId()).get().getRoom().getId();
            if (
                    reservationRepository.findByRoomIdAndCheckOutGreaterThanAndCheckInLessThan(
                            roomId,
                            reservationChangeDateDtoInput.getCheckIn(),
                            reservationChangeDateDtoInput.getCheckOut()
                    ).size() < roomRepository.findById(roomId).get().getMaxHeadCount()
            ) {
                Reservation reservation = reservationRepository.findById(reservationChangeDateDtoInput.getReservationId()).get();
                reservation.setCheckIn(reservationChangeDateDtoInput.getCheckIn());
                reservation.setCheckOut(reservationChangeDateDtoInput.getCheckOut());
                reservationRepository.save(reservation);
                return SystemMessage.builder()
                        .code(1)
                        .message("예약 변경 성공")
                        .build();
            } else {
                return SystemMessage.builder()
                        .code(3)
                        .message("예약 변경 실패: 인원 초과")
                        .build();
            }
        } catch (Exception e) {
            log.error("ReservationService edit Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 변경 실패")
                    .build();
        } finally {
            log.info("ReservationService edit Reservation end");
        }
    }

    @Override
    public Reservation findById(Long id) {
        try {
            log.info("ReservationService find by id Reservation(id: {}) start", id);
            return reservationRepository.findById(id).get();
        } catch (Exception e) {
            log.error("ReservationService find by id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by id Reservation end");
        }
    }

    @Override
    public SystemMessage deleteById(Long id) {
        try {
            log.info("ReservationService delete by id Reservation(id: {}) start", id);
            reservationRepository.deleteById(id);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 삭제 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService delete by id Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 삭제 실패")
                    .build();
        } finally {
            log.info("ReservationService delete by id Reservation end");
        }
    }

    @Override
    public List<Reservation> findByUserId(Long id) {
        try {
            log.info("ReservationService find by user id Reservation(id: {}) start", id);
            return reservationRepository.findByUserId(id);
        } catch (Exception e) {
            log.error("ReservationService find by user id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by user id Reservation end");
        }
    }

    @Override
    public List<Reservation> findByHomeId(Long id) {
        try {
            log.info("ReservationService find by home id Reservation(id: {}) start", id);
            return reservationRepository.findByHomeId(id);
        } catch (Exception e) {
            log.error("ReservationService find by home id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by home id Reservation end");
        }
    }

    @Override
    public List<Reservation> findByUserIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus) {
        try {
            log.info("ReservationService find by user check in, out status Reservation(id: {}) start", id);
            return reservationRepository.findByUserIdAndCheckInStatusAndCheckOutStatusAndDenyStatus(id, checkInStatus, checkOutStatus, denyStatus);
        } catch (Exception e) {
            log.error("ReservationService find by user check in, out status Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by user check in, out status Reservation end");
        }
    }

    @Override
    public SystemMessage changeReservationStatus(Long id, boolean checkInStatus, boolean checkOutStatus) {
        try {
            log.info("ReservationService change reservation status Reservation(id: {}) start", id);
            Reservation reservation = reservationRepository.findById(id).get();
            reservation.setCheckInStatus(checkInStatus);
            reservation.setCheckOutStatus(checkOutStatus);
            reservationRepository.save(reservation);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 상태 변경 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService change reservation status Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 상태 변경 실패")
                    .build();
        } finally {
            log.info("ReservationService change reservation status Reservation end");
        }
    }

    @Override
    public SystemMessage denyReservation(ReservationDenyInput reservationDenyInput) {
        try {
            log.info("ReservationService deny Reservation({}) start", reservationDenyInput);
            Reservation reservation = reservationRepository.findById(reservationDenyInput.getReservationId()).get();
            reservation.setHostToGuest(reservationDenyInput.getHostToGuest());
            reservation.setDenyStatus(true);
            reservationRepository.save(reservation);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 거절 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService deny Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 거절 실패")
                    .build();
        } finally {
            log.info("ReservationService deny Reservation end");
        }
    }

    @Override
    public int headCount(ReservationHeadCountDto reservationHeadCountDto) {
        try {
            log.info("ReservationService head count Reservation({}) start", reservationHeadCountDto);
            return reservationRepository.findByRoomIdAndCheckOutGreaterThanAndCheckInLessThan(reservationHeadCountDto.getRoomId(), reservationHeadCountDto.getCheckIn(), reservationHeadCountDto.getCheckOut()).size();
        } catch (Exception e) {
            log.error("ReservationService head count Reservation failure, error: {}", e.getMessage());
            return -1;
        } finally {
            log.info("ReservationService head count Reservation end");
        }
    }
}
