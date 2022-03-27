package line2.line2_back.reservation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@Builder
public class ReservationHeadCountDto {
    private Long roomId;
    private Date checkIn;
    private Date checkOut;
}
