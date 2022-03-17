package line2.line2_back.homePolicyTable.model;

import line2.line2_back.home.model.Home;
import line2.line2_back.homePolicy.model.HomePolicy;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomePolicyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;
    @ManyToOne
    @JoinColumn(name = "home_policy_id")
    private HomePolicy homePolicy;
}
