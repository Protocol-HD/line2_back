package line2.line2_back.homeFacilityTable.model;

import line2.line2_back.home.model.Home;
import line2.line2_back.homeFacility.model.HomeFacility;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeFacilityTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;
    @ManyToOne
    @JoinColumn(name = "home_facility_id")
    private HomeFacility homeFacility;
}
