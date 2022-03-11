package line2.line2_back.shelterHaveImage.controller;

import line2.line2_back.shelterHaveImage.model.ShelterHaveImage;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDtoInput;

import java.util.List;

public interface ShelterHaveImageController {
    ShelterHaveImage addShelterHaveImage(ShelterHaveImageDtoInput shelterHaveImageDtoInput);

    ShelterHaveImage editShelterHaveImage(ShelterHaveImageDtoInput shelterHaveImageDtoInput);

    ShelterHaveImage findByIdShelterHaveImage(Long id);

    List<ShelterHaveImage> findAllShelterHaveImages();

    void deleteByIdShelterHaveImage(Long id);
}
