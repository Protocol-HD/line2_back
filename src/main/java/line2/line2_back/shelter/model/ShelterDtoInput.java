package line2.line2_back.shelter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ShelterDtoInput {
    private Long id;
    private String shelterName;
    private String shelterAddress;
    private double coordinateX;
    private double coordinateY;
    private Long shelterFacilityId;
}
