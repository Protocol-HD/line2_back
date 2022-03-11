package line2.line2_back.shelter.model;

import line2.line2_back.shelterFacility.model.ShelterFacility;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shelterName;
    private String shelterAddress;
    private double coordinateX;
    private double coordinateY;
    @ManyToOne
    @JoinColumn(name = "shelter_facility_id")
    private ShelterFacility shelterFacility;
}
