package line2.line2_back.home.model;

import line2.line2_back.homeCategory.model.HomeCategory;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String homeName;
    private String homeAddress;
    private double coordinateX;
    private double coordinateY;
    @ManyToOne
    @JoinColumn(name = "home_category_id")
    private HomeCategory homeCategory;
    private String homeInfomation;
    private String homeHost;
    private String homeHostPhone;
    private String homeHostEmail;
    private String homeZipCode;
}
