package line2.line2_back.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long reservationId;
    private Long homeId;
    private Long roomId;
    private Long userId;
    private Date checkIn;
    private Date checkOut;
    private String guestToHost;
}
