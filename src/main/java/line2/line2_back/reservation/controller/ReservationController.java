package line2.line2_back.reservation.controller;

import line2.line2_back.reservation.model.*;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.Date;
import java.util.List;

public interface ReservationController {
    SystemMessage add(ReservationDto reservationDto);

    SystemMessage edit(ReservationChangeDateDtoInput reservationChangeDateDtoInput);

    Reservation findById(Long id);

    SystemMessage deleteById(Long id);

    List<Reservation> findByUserId(Long id);

    List<Reservation> findByHomeId(Long id);

    List<Reservation> findByUserIdBeforeCheckIn(Long id);

    List<Reservation> findByUserIdBeforeCheckOut(Long id);

    List<Reservation> findByUserIdAfterCheckOut(Long id);

    List<Reservation> findByUserDenyReservation(Long id);

    SystemMessage acceptCheckIn(Long id);

    SystemMessage acceptCheckOut(Long id);

    SystemMessage denyReservation(ReservationDenyInput reservationDenyInput);

    int headCount(ReservationHeadCountDto reservationHeadCountDto);

    SystemMessage isEnableDeleteRoom(Long id);
}
