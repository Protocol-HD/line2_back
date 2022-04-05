package line2.line2_back.reservation.controller;

import line2.line2_back.reservation.model.*;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.List;

public interface ReservationController {
    SystemMessage add(ReservationDto reservationDto);

    SystemMessage edit(ReservationChangeDateDtoInput reservationChangeDateDtoInput);

    Reservation findById(Long id);

    SystemMessage deleteById(Long id);

    List<Reservation> findByUserId(Long id);

    List<Reservation> findByHomeId(Long id);

    List<Reservation> findByRoomId(Long id);

    List<Reservation> findByHomeIdBeforeCheckIn(Long id);

    List<Reservation> findByHomeIdBeforeCheckOut(Long id);

    List<Reservation> findByHomeIdAfterCheckOut(Long id);
    
    List<Reservation> findByUserIdBeforeCheckIn(Long id);

    List<Reservation> findByUserIdBeforeCheckOut(Long id);

    List<Reservation> findByUserIdAfterCheckOut(Long id);

    List<Reservation> findByUserDenyReservation(Long id);

    SystemMessage acceptCheckIn(ReservationCheckInOutInput reservationCheckInOutInput);

    SystemMessage acceptCheckOut(ReservationCheckInOutInput reservationCheckInOutInput);

    SystemMessage denyReservation(ReservationCheckInOutInput reservationDenyInput);

    int headCount(ReservationHeadCountDto reservationHeadCountDto);

    SystemMessage isEnableDeleteRoom(Long id);
}
