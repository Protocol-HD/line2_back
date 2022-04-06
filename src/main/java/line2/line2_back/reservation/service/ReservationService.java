package line2.line2_back.reservation.service;

import line2.line2_back.reservation.model.*;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.List;

public interface ReservationService {
    SystemMessage add(ReservationDto reservationDto);

    SystemMessage edit(ReservationChangeDateDtoInput reservationChangeDateDtoInput);

    Reservation findById(Long id);

    SystemMessage deleteById(Long id);

    List<Reservation> findByUserId(Long id);

    List<Reservation> findByHomeId(Long id);

    List<Reservation> findByRoomId(Long id);

    List<Reservation> findByHomeIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus, boolean cancelStatus);

    List<Reservation> findByUserIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus, boolean cancelStatus);

    SystemMessage changeReservationStatus(Long id, boolean checkInStatus, boolean checkOutStatus, String checkInMessage, String checkOutMessage);

    SystemMessage denyReservation(ReservationCheckInOutInput reservationCheckInOutInput);

    SystemMessage cancelReservation(ReservationCheckInOutInput reservationCheckInOutInput);

    int headCount(ReservationHeadCountDto reservationHeadCountDto);

    SystemMessage isEnableDeleteRoom(Long id);
}
