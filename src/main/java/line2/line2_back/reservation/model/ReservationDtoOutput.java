package line2.line2_back.reservation.model;

import java.util.Date;

import line2.line2_back.restApi.models.Home;
import line2.line2_back.restApi.models.Room;
import line2.line2_back.restApi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDtoOutput {
    private Long id;
    private Home home;
    private Room room;
    private User user;
    private Date checkIn;
    private Date checkOut;
    private String checkInMessage;
    private String checkOutMessage;
    private String denyMessage;
    private String cancelMessage;
    private String guestToHost;
}
