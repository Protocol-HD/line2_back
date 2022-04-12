package line2.line2_back.reservation.service;

import line2.line2_back.reservation.model.*;
import line2.line2_back.reservation.repository.ReservationRepository;
import line2.line2_back.restApi.RestApiService;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RestApiService restApiService;

    @Override
    public SystemMessage add(ReservationDto reservationDto) {
        try {
            log.info("ReservationService add Reservation({}) start", reservationDto);
            if (reservationRepository.findByRoomIdAndCheckOutGreaterThanAndCheckInLessThan(
                    reservationDto.getRoomId(),
                    reservationDto.getCheckIn(),
                    reservationDto.getCheckOut())
                    .size() < restApiService.getRoomById(reservationDto.getRoomId()).getMaxHeadCount()) {
                reservationRepository.save(Reservation.builder()
                        .id(reservationDto.getReservationId())
                        .homeId(reservationDto.getHomeId())
                        .roomId(reservationDto.getRoomId())
                        .userId(reservationDto.getUserId())
                        .checkIn(reservationDto.getCheckIn())
                        .checkOut(reservationDto.getCheckOut())
                        .guestToHost(reservationDto.getGuestToHost())
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
            Long roomId = reservationRepository.findById(reservationChangeDateDtoInput.getReservationId()).get()
                    .getRoomId();
            if (reservationRepository.findByRoomIdAndCheckOutGreaterThanAndCheckInLessThan(
                    roomId,
                    reservationChangeDateDtoInput.getCheckIn(),
                    reservationChangeDateDtoInput.getCheckOut())
                    .size() < restApiService.getRoomById(roomId).getMaxHeadCount()) {
                Reservation reservation = reservationRepository
                        .findById(reservationChangeDateDtoInput.getReservationId()).get();
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
    public ReservationDtoOutput findById(Long id) {
        try {
            log.info("ReservationService find by id Reservation(id: {}) start", id);
            Reservation reservation = reservationRepository.findById(id).get();
            return ReservationDtoOutput.builder()
                    .id(reservation.getId())
                    .home(restApiService.getHomeById(reservation.getHomeId()))
                    .room(restApiService.getRoomById(reservation.getRoomId()))
                    .user(restApiService.getUserById(reservation.getUserId()))
                    .checkIn(reservation.getCheckIn())
                    .checkOut(reservation.getCheckOut())
                    .checkInMessage(reservation.getCheckInMessage())
                    .checkOutMessage(reservation.getCheckOutMessage())
                    .denyMessage(reservation.getDenyMessage())
                    .cancelMessage(reservation.getCancelMessage())
                    .guestToHost(reservation.getGuestToHost())
                    .build();
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

    public List<ReservationDtoOutput> makeReservationDtoOutPutList(List<Reservation> reservations) {
        List<ReservationDtoOutput> reservationDtoOutputs = new ArrayList<>();
        reservations.forEach(reservation -> {
            reservationDtoOutputs.add(ReservationDtoOutput.builder()
                    .id(reservation.getId())
                    .home(restApiService.getHomeById(reservation.getHomeId()))
                    .room(restApiService.getRoomById(reservation.getRoomId()))
                    .user(restApiService.getUserById(reservation.getUserId()))
                    .checkIn(reservation.getCheckIn())
                    .checkOut(reservation.getCheckOut())
                    .checkInMessage(reservation.getCheckInMessage())
                    .checkOutMessage(reservation.getCheckOutMessage())
                    .denyMessage(reservation.getDenyMessage())
                    .cancelMessage(reservation.getCancelMessage())
                    .guestToHost(reservation.getGuestToHost())
                    .build());
        });
        return reservationDtoOutputs;
    }

    @Override
    public List<ReservationDtoOutput> findByUserId(Long id) {
        try {
            log.info("ReservationService find by user id Reservation(id: {}) start", id);
            return makeReservationDtoOutPutList(reservationRepository.findByUserId(id));
        } catch (Exception e) {
            log.error("ReservationService find by user id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by user id Reservation end");
        }
    }

    @Override
    public List<ReservationDtoOutput> findByHomeId(Long id) {
        try {
            log.info("ReservationService find by home id Reservation(id: {}) start", id);
            return makeReservationDtoOutPutList(reservationRepository.findByHomeId(id));
        } catch (Exception e) {
            log.error("ReservationService find by home id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by home id Reservation end");
        }
    }

    @Override
    public List<ReservationDtoOutput> findByRoomId(Long id) {
        try {
            log.info("ReservationService find by room id Reservation(id: {}) start", id);
            return makeReservationDtoOutPutList(reservationRepository.findByRoomId(id));
        } catch (Exception e) {
            log.error("ReservationService find by room id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by room id Reservation end");
        }
    }

    @Override
    public List<ReservationDtoOutput> findByHomeIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus,
            boolean denyStatus, boolean cancelStatus) {
        try {
            log.info("ReservationService find by home check in, out status Reservation(id: {}) start", id);
            return makeReservationDtoOutPutList(
                    reservationRepository.findByHomeIdAndCheckInStatusAndCheckOutStatusAndDenyStatusAndCancelStatus(id,
                            checkInStatus,
                            checkOutStatus, denyStatus, cancelStatus));
        } catch (Exception e) {
            log.error("ReservationService find by home check in, out status Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by home check in, out status Reservation end");
        }
    }

    @Override
    public List<ReservationDtoOutput> findByUserIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus,
            boolean denyStatus, boolean cancelStatus) {
        try {
            log.info("ReservationService find by user check in, out status Reservation(id: {}) start", id);
            return makeReservationDtoOutPutList(
                    reservationRepository.findByUserIdAndCheckInStatusAndCheckOutStatusAndDenyStatusAndCancelStatus(id,
                            checkInStatus,
                            checkOutStatus, denyStatus, cancelStatus));
        } catch (Exception e) {
            log.error("ReservationService find by user check in, out status Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationService find by user check in, out status Reservation end");
        }
    }

    @Override
    public SystemMessage changeReservationStatus(Long id, boolean checkInStatus, boolean checkOutStatus,
            String checkInMessage, String checkOutMessage) {
        try {
            log.info("ReservationService change reservation status Reservation(id: {}) start", id);
            Reservation reservation = reservationRepository.findById(id).get();
            reservation.setCheckInStatus(checkInStatus);
            reservation.setCheckOutStatus(checkOutStatus);
            reservation.setCheckInMessage(checkInMessage);
            reservation.setCheckOutMessage(checkOutMessage);
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
    public SystemMessage denyReservation(ReservationCheckInOutInput reservationCheckInOutInput) {
        try {
            log.info("ReservationService deny Reservation({}) start", reservationCheckInOutInput);
            Reservation reservation = reservationRepository.findById(reservationCheckInOutInput.getReservationId())
                    .get();
            reservation.setDenyMessage(reservationCheckInOutInput.getMessage());
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
    public SystemMessage cancelReservation(ReservationCheckInOutInput reservationCheckInOutInput) {
        try {
            log.info("ReservationService cancel Reservation({}) start", reservationCheckInOutInput);
            Reservation reservation = reservationRepository.findById(reservationCheckInOutInput.getReservationId())
                    .get();
            reservation.setCancelMessage(reservationCheckInOutInput.getMessage());
            reservation.setCancelStatus(true);
            reservationRepository.save(reservation);
            return SystemMessage.builder()
                    .code(1)
                    .message("예약 취소 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService cancel Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 취소 실패")
                    .build();
        } finally {
            log.info("ReservationService cancel Reservation end");
        }
    }

    @Override
    public int headCount(ReservationHeadCountDto reservationHeadCountDto) {
        try {
            log.info("ReservationService head count Reservation({}) start", reservationHeadCountDto);
            return reservationRepository
                    .findByRoomIdAndCheckOutGreaterThanAndCheckInLessThan(reservationHeadCountDto.getRoomId(),
                            reservationHeadCountDto.getCheckIn(), reservationHeadCountDto.getCheckOut())
                    .size();
        } catch (Exception e) {
            log.error("ReservationService head count Reservation failure, error: {}", e.getMessage());
            return -1;
        } finally {
            log.info("ReservationService head count Reservation end");
        }
    }

    @Override
    public SystemMessage isEnableDeleteRoom(Long id) {
        try {
            log.info("ReservationService find exist next Reservation(id: {}) start", id);
            if (reservationRepository
                    .findByRoomIdAndCheckOutGreaterThanAndCheckInGreaterThan(id, new Date(), new Date()).size() == 0) {
                return SystemMessage.builder()
                        .code(1)
                        .message("객실 삭제 가능")
                        .build();
            }
            return SystemMessage.builder()
                    .code(3)
                    .message("객실 삭제 불가: 예정된 예약이 존재함")
                    .build();
        } catch (Exception e) {
            log.error("ReservationService find exist next Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("객실 삭제 검증 실패")
                    .build();
        } finally {
            log.info("ReservationService find exist next Reservation end");
        }
    }
}
