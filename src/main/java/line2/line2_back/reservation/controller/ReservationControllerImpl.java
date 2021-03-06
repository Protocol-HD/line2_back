package line2.line2_back.reservation.controller;

import line2.line2_back.reservation.model.*;
import line2.line2_back.reservation.service.ReservationService;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class ReservationControllerImpl implements ReservationController {
    private final ReservationService reservationService;

    @Override
    @PostMapping("/v1/reservation")
    public SystemMessage add(@RequestBody ReservationDto reservationDto) {
        try {
            log.info("ReservationController add Reservation({}) start", reservationDto);
            return reservationService.add(reservationDto);
        } catch (Exception e) {
            log.error("ReservationController add Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 실패")
                    .build();
        } finally {
            log.info("ReservationController add Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation")
    public SystemMessage edit(@RequestBody ReservationChangeDateDtoInput reservationChangeDateDtoInput) {
        try {
            log.info("ReservationController edit Reservation({}) start", reservationChangeDateDtoInput);
            return reservationService.edit(reservationChangeDateDtoInput);
        } catch (Exception e) {
            log.error("ReservationController edit Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 변경 실패")
                    .build();
        } finally {
            log.info("ReservationController edit Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/{id}")
    public ReservationDtoOutput findById(@PathVariable Long id) {
        try {
            log.info("ReservationController find by id Reservation(id: {}) start", id);
            return reservationService.findById(id);
        } catch (Exception e) {
            log.error("ReservationController find by id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by id Reservation end");
        }
    }

    @Override
    @DeleteMapping("/v1/reservation/{id}")
    public SystemMessage deleteById(@PathVariable Long id) {
        try {
            log.info("ReservationController delete by id Reservation(id: {}) start", id);
            return reservationService.deleteById(id);
        } catch (Exception e) {
            log.error("ReservationController delete by id Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 삭제 실패")
                    .build();
        } finally {
            log.info("ReservationController delete by id Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/{id}")
    public List<ReservationDtoOutput> findByUserId(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user id Reservation(id: {}) start", id);
            return reservationService.findByUserId(id);
        } catch (Exception e) {
            log.error("ReservationController find by user id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user id Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/home/{id}")
    public List<ReservationDtoOutput> findByHomeId(@PathVariable Long id) {
        try {
            log.info("ReservationController find by home id Reservation(id: {}) start", id);
            return reservationService.findByHomeId(id);
        } catch (Exception e) {
            log.error("ReservationController find by home id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by home id Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/room/{id}")
    public List<ReservationDtoOutput> findByRoomId(Long id) {
        try {
            log.info("ReservationController find by room id Reservation(id: {}) start", id);
            return reservationService.findByRoomId(id);
        } catch (Exception e) {
            log.error("ReservationController find by room id Reservation failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by room id Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/home/before_check_in/{id}")
    public List<ReservationDtoOutput> findByHomeIdBeforeCheckIn(@PathVariable Long id) {
        try {
            log.info("ReservationController find by home before check in Reservation(id: {}) start", id);
            List<ReservationDtoOutput> reservations = new ArrayList<>();
            reservations.addAll(reservationService.findByHomeIdCheckInOut(id, false, false, false, false));
            return reservations;
        } catch (Exception e) {
            log.error("ReservationController find by home before check in Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by home before check in Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/home/before_check_out/{id}")
    public List<ReservationDtoOutput> findByHomeIdBeforeCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController find by home before check out Reservation(id: {}) start", id);
            return reservationService.findByHomeIdCheckInOut(id, true, false, false, false);
        } catch (Exception e) {
            log.error("ReservationController find by home before check out Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by home before check out Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/home/after_check_out/{id}")
    public List<ReservationDtoOutput> findByHomeIdAfterCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController find by home after check out Reservation(id: {}) start", id);
            return reservationService.findByHomeIdCheckInOut(id, true, true, false, false);
        } catch (Exception e) {
            log.error("ReservationController find by home after check out Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by home after check out Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/home/deny/{id}")
    public List<ReservationDtoOutput> findByHomeDenyReservation(@PathVariable Long id) {
        try {
            log.info("ReservationController find by home deny Reservation(id: {}) start", id);
            return reservationService.findByHomeIdCheckInOut(id, false, false, true, false);
        } catch (Exception e) {
            log.error("ReservationController find by home deny Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by home deny Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/home/cancel/{id}")
    public List<ReservationDtoOutput> findByHomeCancelReservation(@PathVariable Long id) {
        try {
            log.info("ReservationController find by home cancel Reservation(id: {}) start", id);
            return reservationService.findByHomeIdCheckInOut(id, false, false, true, false);
        } catch (Exception e) {
            log.error("ReservationController find by home cancel Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by home cancel Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/before_check_in/{id}")
    public List<ReservationDtoOutput> findByUserIdBeforeCheckIn(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user before check in Reservation(id: {}) start", id);
            List<ReservationDtoOutput> reservations = new ArrayList<>();
            reservations.addAll(reservationService.findByUserIdCheckInOut(id, false, false, false, false));
            return reservations;
        } catch (Exception e) {
            log.error("ReservationController find by user before check in Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user before check in Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/before_check_out/{id}")
    public List<ReservationDtoOutput> findByUserIdBeforeCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user before check out Reservation(id: {}) start", id);
            return reservationService.findByUserIdCheckInOut(id, true, false, false, false);
        } catch (Exception e) {
            log.error("ReservationController find by user before check out Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user before check out Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/after_check_out/{id}")
    public List<ReservationDtoOutput> findByUserIdAfterCheckOut(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user after check out Reservation(id: {}) start", id);
            return reservationService.findByUserIdCheckInOut(id, true, true, false, false);
        } catch (Exception e) {
            log.error("ReservationController find by user after check out Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user after check out Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/deny/{id}")
    public List<ReservationDtoOutput> findByUserDenyReservation(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user deny Reservation(id: {}) start", id);
            return reservationService.findByUserIdCheckInOut(id, false, false, true, false);
        } catch (Exception e) {
            log.error("ReservationController find by user deny Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user deny Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/user/cancel/{id}")
    public List<ReservationDtoOutput> findByUserCancelReservation(@PathVariable Long id) {
        try {
            log.info("ReservationController find by user cancel Reservation(id: {}) start", id);
            return reservationService.findByUserIdCheckInOut(id, false, false, false, true);
        } catch (Exception e) {
            log.error("ReservationController find by user cancel Reservation failure, error: {}",
                    e.getMessage());
            return null;
        } finally {
            log.info("ReservationController find by user cancel Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation/accept_check_in")
    public SystemMessage acceptCheckIn(@RequestBody ReservationCheckInOutInput reservationCheckInOutInput) {
        try {
            log.info("ReservationController accept check in Reservation({}) start", reservationCheckInOutInput);
            return reservationService.changeReservationStatus(reservationCheckInOutInput.getReservationId(), true,
                    false, reservationCheckInOutInput.getMessage(),
                    reservationService.findById(reservationCheckInOutInput.getReservationId()).getCheckOutMessage());
        } catch (Exception e) {
            log.error("ReservationController accept check in Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 상태 변경 실패")
                    .build();
        } finally {
            log.info("ReservationController accept check in Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation/accept_check_out")
    public SystemMessage acceptCheckOut(@RequestBody ReservationCheckInOutInput reservationCheckInOutInput) {
        try {
            log.info("ReservationController accept check out Reservation({}) start", reservationCheckInOutInput);
            return reservationService.changeReservationStatus(reservationCheckInOutInput.getReservationId(), true, true,
                    reservationService.findById(reservationCheckInOutInput.getReservationId()).getCheckInMessage(),
                    reservationCheckInOutInput.getMessage());
        } catch (Exception e) {
            log.error("ReservationController accept check out Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 상태 변경 실패")
                    .build();
        } finally {
            log.info("ReservationController accept check out Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation/deny")
    public SystemMessage denyReservation(@RequestBody ReservationCheckInOutInput reservationCheckInOutInput) {
        try {
            log.info("ReservationController deny Reservation({}) start", reservationCheckInOutInput);
            return reservationService.denyReservation(reservationCheckInOutInput);
        } catch (Exception e) {
            log.error("ReservationController deny Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 거절 실패")
                    .build();
        } finally {
            log.info("ReservationController deny Reservation end");
        }
    }

    @Override
    @PutMapping("/v1/reservation/cancel")
    public SystemMessage cancelReservation(@RequestBody ReservationCheckInOutInput reservationCheckInOutInput) {
        try {
            log.info("ReservationController cancel Reservation({}) start", reservationCheckInOutInput);
            return reservationService.cancelReservation(reservationCheckInOutInput);
        } catch (Exception e) {
            log.error("ReservationController cancel Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("예약 취소 실패")
                    .build();
        } finally {
            log.info("ReservationController cancel Reservation end");
        }
    }

    @Override
    @PostMapping("/v1/reservation/head_count")
    public int headCount(@RequestBody ReservationHeadCountDto reservationHeadCountDto) {
        try {
            log.info("ReservationController head count Reservation({}) start", reservationHeadCountDto);
            return reservationService.headCount(reservationHeadCountDto);
        } catch (Exception e) {
            log.error("ReservationController head count Reservation failure, error: {}", e.getMessage());
            return -1;
        } finally {
            log.info("ReservationController head count Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/delete_room/{id}")
    public SystemMessage isEnableDeleteRoom(@PathVariable Long id) {
        try {
            log.info("ReservationController find exist next Reservation(id: {}) start", id);
            return reservationService.isEnableDeleteRoom(id);
        } catch (Exception e) {
            log.error("ReservationController find exist next Reservation failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("객실 삭제 검증 실패")
                    .build();
        } finally {
            log.info("ReservationController find exist next Reservation end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/calendar/{id}")
    public List<ReservationCalendar> getReservationCalendar(@PathVariable Long id) {
        try {
            log.info("ReservationController get getReservationCalendar(room id: {}) start", id);
            return reservationService.getReservationCalendar(id, 0, 62);
        } catch (Exception e) {
            log.error("ReservationController get getReservationCalendar failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController get getReservationCalendar end");
        }
    }

    @Override
    @GetMapping("/v1/reservation/calendars/{id}")
    public List<ReservationRoomCalendar> getReservationCalendars(@PathVariable Long id) {
        try {
            log.info("ReservationController get getReservationCalendars(user id: {}) start", id);
            return reservationService.getReservationCalendars(id);
        } catch (Exception e) {
            log.error("ReservationController get getReservationCalendars failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ReservationController get getReservationCalendars end");
        }
    }
}
