package line2.line2_back.shelterImage.model;

import line2.line2_back.image.model.Image;
import line2.line2_back.shelter.model.Shelter;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShelterImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;
}
