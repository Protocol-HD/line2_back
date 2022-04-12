package line2.line2_back.reservation.service;

import line2.line2_back.reservation.model.*;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.List;

public interface ReservationService {
    SystemMessage add(ReservationDto reservationDto);

    SystemMessage edit(ReservationChangeDateDtoInput reservationChangeDateDtoInput);

    ReservationDtoOutput findById(Long id);

    SystemMessage deleteById(Long id);

    List<ReservationDtoOutput> findByUserId(Long id);

    List<ReservationDtoOutput> findByHomeId(Long id);

    List<ReservationDtoOutput> findByRoomId(Long id);

    List<ReservationDtoOutput> findByHomeIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus, boolean cancelStatus);

    List<ReservationDtoOutput> findByUserIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus, boolean cancelStatus);

    SystemMessage changeReservationStatus(Long id, boolean checkInStatus, boolean checkOutStatus, String checkInMessage, String checkOutMessage);

    SystemMessage denyReservation(ReservationCheckInOutInput reservationCheckInOutInput);

    SystemMessage cancelReservation(ReservationCheckInOutInput reservationCheckInOutInput);

    int headCount(ReservationHeadCountDto reservationHeadCountDto);

    SystemMessage isEnableDeleteRoom(Long id);

    List<ReservationCalendar> getReservationCalendar(Long id);
}
