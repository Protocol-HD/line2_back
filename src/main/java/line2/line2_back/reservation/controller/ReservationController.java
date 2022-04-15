package line2.line2_back.reservation.controller;

import line2.line2_back.reservation.model.*;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.Date;
import java.util.List;

public interface ReservationController {
    SystemMessage add(ReservationDto reservationDto);

    SystemMessage edit(ReservationChangeDateDtoInput reservationChangeDateDtoInput);

    ReservationDtoOutput findById(Long id);

    SystemMessage deleteById(Long id);

    List<ReservationDtoOutput> findByUserId(Long id);

    List<ReservationDtoOutput> findByHomeId(Long id);

    List<ReservationDtoOutput> findByRoomId(Long id);

    List<ReservationDtoOutput> findByHomeIdBeforeCheckIn(Long id);

    List<ReservationDtoOutput> findByHomeIdBeforeCheckOut(Long id);

    List<ReservationDtoOutput> findByHomeIdAfterCheckOut(Long id);

    List<ReservationDtoOutput> findByHomeDenyReservation(Long id);

    List<ReservationDtoOutput> findByHomeCancelReservation(Long id);
    
    List<ReservationDtoOutput> findByUserIdBeforeCheckIn(Long id);

    List<ReservationDtoOutput> findByUserIdBeforeCheckOut(Long id);

    List<ReservationDtoOutput> findByUserIdAfterCheckOut(Long id);

    List<ReservationDtoOutput> findByUserDenyReservation(Long id);

    List<ReservationDtoOutput> findByUserCancelReservation(Long id);

    SystemMessage acceptCheckIn(ReservationCheckInOutInput reservationCheckInOutInput);

    SystemMessage acceptCheckOut(ReservationCheckInOutInput reservationCheckInOutInput);

    SystemMessage denyReservation(ReservationCheckInOutInput reservationCheckInOutInput);

    SystemMessage cancelReservation(ReservationCheckInOutInput reservationCheckInOutInput);

    int headCount(ReservationHeadCountDto reservationHeadCountDto);

    SystemMessage isEnableDeleteRoom(Long id);

    List<ReservationCalendar> getReservationCalendar(Long id);
}
