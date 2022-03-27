package line2.line2_back.home.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Builder
public class HomeListDto {
    private Long homeId;
    private String homeName;
    private String homeAddress;
    private double coordinateX;
    private double coordinateY;
    private Long homeCategoryId;
    private String image;
    private List<Long> homeFacilities;
}
