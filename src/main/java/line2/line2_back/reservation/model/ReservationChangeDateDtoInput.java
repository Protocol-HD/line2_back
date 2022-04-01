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
public class ReservationChangeDateDtoInput {
    private Long reservationId;
    private Date checkIn;
    private Date checkOut;
}
