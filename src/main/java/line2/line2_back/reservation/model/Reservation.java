package line2.line2_back.reservation.model;

import line2.line2_back.home.model.Home;
import line2.line2_back.room.model.Room;
import line2.line2_back.user.model.User;
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
public class Reservation {
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
    private String hostToGuest;
    private String guestToHost;
    @ColumnDefault("false")
    private boolean checkInStatus;
    @ColumnDefault("false")
    private boolean checkOutStatus;
    @ColumnDefault("false")
    private boolean denyStatus;
}
