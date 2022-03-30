package line2.line2_back.reservation.service;

import line2.line2_back.reservation.model.*;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    SystemMessage add(ReservationDto reservationDto);

    SystemMessage edit(ReservationChangeDateDtoInput reservationChangeDateDtoInput);

    Reservation findById(Long id);

    SystemMessage deleteById(Long id);

    List<Reservation> findByUserId(Long id);

    List<Reservation> findByHomeId(Long id);

    List<Reservation> findByUserIdCheckInOut(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus);

    SystemMessage changeReservationStatus(Long id, boolean checkInStatus, boolean checkOutStatus);

    SystemMessage denyReservation(ReservationDenyInput reservationDenyInput);

    int headCount(ReservationHeadCountDto reservationHeadCountDto);

    SystemMessage isEnableDeleteRoom(Long id);
}
