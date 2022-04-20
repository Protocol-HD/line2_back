package line2.line2_back.reservation.service;

import line2.line2_back.reservation.model.*;
import line2.line2_back.reservation.repository.ReservationRepository;
import line2.line2_back.restApi.RestApiService;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
            if (reservationRepository
                    .findByUserIdAndCheckOutGreaterThanAndCheckInLessThanAndCheckOutStatusAndDenyStatusAndCancelStatus(
                            reservationDto.getUserId(),
                            reservationDto.getCheckIn(), reservationDto.getCheckOut(), false, false, false)
                    .size() > 0) {
                return SystemMessage.builder()
                        .code(4)
                        .message("예약 실패: 다른 예약 존재")
                        .build();
            } else {
                if (reservationRepository
                        .findByRoomIdAndCheckOutGreaterThanAndCheckInLessThanAndCheckOutStatusAndDenyStatusAndCancelStatus(
                                reservationDto.getRoomId(),
                                reservationDto.getCheckIn(),
                                reservationDto.getCheckOut(), false, false, false)
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
            Reservation reservation = reservationRepository.findById(reservationChangeDateDtoInput.getReservationId())
                    .get();
            if (reservationRepository
                    .findByUserIdAndCheckOutGreaterThanAndCheckInLessThanAndCheckOutStatusAndDenyStatusAndCancelStatus(
                            reservation.getUserId(),
                            reservationChangeDateDtoInput.getCheckIn(), reservationChangeDateDtoInput.getCheckOut(),
                            false, false, false)
                    .size() > 0) {
                return SystemMessage.builder()
                        .code(4)
                        .message("예약 변경 실패: 다른 예약 존재")
                        .build();
            } else {
                if (reservationRepository
                        .findByRoomIdAndCheckOutGreaterThanAndCheckInLessThanAndCheckOutStatusAndDenyStatusAndCancelStatus(
                                reservation.getId(),
                                reservationChangeDateDtoInput.getCheckIn(),
                                reservationChangeDateDtoInput.getCheckOut(), false, false, false)
                        .size() < restApiService.getRoomById(reservation.getId()).getMaxHeadCount()) {
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
                    .homeImage(restApiService.getHomeImageById(reservation.getHomeId()))
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
                    .homeImage(restApiService.getHomeImageById(reservation.getHomeId()))
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
                    .findByRoomIdAndCheckOutGreaterThanAndCheckInLessThanAndCheckOutStatusAndDenyStatusAndCancelStatus(
                            reservationHeadCountDto.getRoomId(),
                            reservationHeadCountDto.getCheckIn(), reservationHeadCountDto.getCheckOut(), false, false,
                            false)
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
                    .findByRoomIdAndCheckOutGreaterThanAndCheckInGreaterThanAndCheckOutStatusAndDenyStatusAndCancelStatus(
                            id, new Date(), new Date(), false, false, false)
                    .size() == 0) {
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

    @Override
    public List<ReservationCalendar> getReservationCalendar(Long id, int before, int day) {
        try {
            log.info("ReservationService get getReservationCalendar(room id: {}) start", id);
            List<ReservationCalendar> reservationCalendars = new ArrayList<>();

            Calendar cal = Calendar.getInstance();
            Calendar now = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            cal.clear();
            cal.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));
            cal.add(Calendar.MONTH, -before);

            int maxHeadCount = restApiService.getRoomById(id).getMaxHeadCount();
            for (int i = 0; i < day; i++) {
                int headCount = reservationRepository
                        .findByRoomIdAndCheckInLessThanEqualAndCheckOutGreaterThanEqualAndCheckOutStatusAndDenyStatusAndCancelStatus(
                                id, cal.getTime(), cal.getTime(), false, false, false)
                        .size();
                String color;
                switch ((int) ((double) headCount / (double) maxHeadCount * 10)) {
                    case 1:
                        color = "#2f9d27";
                        break;
                    case 2:
                        color = "#2f9d27";
                        break;
                    case 3:
                        color = "#47c83e";
                        break;
                    case 4:
                        color = "#47c83e";
                        break;
                    case 5:
                        color = "#86e57f";
                        break;
                    case 6:
                        color = "#86e57f";
                        break;
                    case 7:
                        color = "#e5d85c";
                        break;
                    case 8:
                        color = "#ffbb00";
                        break;
                    case 9:
                        color = "#ffbb00";
                        break;
                    case 10:
                        color = "#f15f5f";
                        break;
                    default:
                        color = "#2f9d27";
                        break;
                }
                reservationCalendars.add(ReservationCalendar.builder()
                        .date(simpleDateFormat.format(cal.getTime()))
                        .title(maxHeadCount - headCount + " / " + maxHeadCount + " " +  "남음")
                        .color(color)
                        .build());
                cal.add(Calendar.DATE, 1);
            }
            return reservationCalendars;
        } catch (Exception e) {
            log.error("ReservationService get getReservationCalendar failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService getReservationCalendar end");
        }
    }

    @Override
    public List<ReservationRoomCalendar> getReservationCalendars(Long id) {
        try {
            log.info("ReservationService get getReservationCalendars(user id: {}) start", id);
            List<ReservationRoomCalendar> reservationRoomCalendars = new ArrayList<>();
            restApiService.getRoomsByUserId(id).forEach(room -> {
                reservationRoomCalendars.add(ReservationRoomCalendar.builder()
                .roomName(room.getRoomName())
                .calendar(getReservationCalendar(room.getId(), 1, 93))
                .build());
            });
            return reservationRoomCalendars;
        } catch (Exception e) {
            log.error("ReservationService get getReservationCalendars failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationService get getReservationCalendars end");
        }
    }
}
