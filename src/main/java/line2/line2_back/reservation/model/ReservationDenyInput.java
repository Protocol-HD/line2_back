package line2.line2_back.reservation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ReservationDenyInput {
    private Long reservationId;
    private String hostToGuest;
}
