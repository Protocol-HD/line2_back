package line2.line2_back.restApi.models;

import lombok.*;

import javax.persistence.*;

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
    private String homeInformation;
    private Long userId;
    private String homeZipCode;
    @ManyToOne
    @JoinColumn(name = "check_in_time")
    private CheckTime checkInTime;
    @ManyToOne
    @JoinColumn(name = "check_out_time")
    private CheckTime checkOutTime;
}