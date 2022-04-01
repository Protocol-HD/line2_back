package line2.line2_back.reservation.repository;

import line2.line2_back.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long id);

    List<Reservation> findByHomeId(Long id);

    List<Reservation> findByRoomId(Long id);

    List<Reservation> findByUserIdAndCheckInStatusAndCheckOutStatusAndDenyStatus(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus);

    List<Reservation> findByHomeIdAndCheckInStatusAndCheckOutStatusAndDenyStatus(Long id, boolean checkInStatus, boolean checkOutStatus, boolean denyStatus);

    List<Reservation> findByRoomIdAndCheckOutGreaterThanAndCheckInLessThan(Long id, Date checkIn, Date checkOut);

    List<Reservation> findByRoomIdAndCheckOutGreaterThanAndCheckInGreaterThan(Long id, Date checkIn, Date checkOut);
}
