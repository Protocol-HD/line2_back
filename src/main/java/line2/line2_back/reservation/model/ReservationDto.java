package line2.line2_back.reservation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@Builder
public class ReservationDto {
    private Long reservationId;
    private Long homeId;
    private Long roomId;
    private Long userId;
    private Date checkIn;
    private Date checkOut;
    private String guestToHost;
}
