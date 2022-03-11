package line2.line2_back.shelterHaveImage.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ShelterHaveImageDtoInput {
    private Long id;
    private Long imageId;
    private Long shelterId;
}
