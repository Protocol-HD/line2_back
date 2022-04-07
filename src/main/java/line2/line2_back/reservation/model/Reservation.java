package line2.line2_back.reservation.model;

import line2.line2_back.restApi.models.Home;
import line2.line2_back.restApi.models.Room;
import line2.line2_back.restApi.models.User;
import line2.line2_back.util.BaseTime;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date checkIn;
    private Date checkOut;
    private String checkInMessage;
    private String checkOutMessage;
    private String denyMessage;
    private String cancelMessage;
    private String guestToHost;
    @ColumnDefault("false")
    private boolean checkInStatus;
    @ColumnDefault("false")
    private boolean checkOutStatus;
    @ColumnDefault("false")
    private boolean denyStatus;
    @ColumnDefault("false")
    private boolean cancelStatus;
}
