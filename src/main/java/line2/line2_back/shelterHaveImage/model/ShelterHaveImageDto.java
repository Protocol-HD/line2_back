package line2.line2_back.shelterHaveImage.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShelterHaveImageDto {
    private Long id;
    private Long imageId;
    private Long shelterId;
}
