package line2.line2_back.shelterHaveImage.controller;

import line2.line2_back.shelterHaveImage.model.ShelterHaveImage;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDto;

import java.util.List;

public interface ShelterHaveImageController {
    ShelterHaveImage addShelterHaveImage(ShelterHaveImageDto shelterHaveImageDto);

    ShelterHaveImage editShelterHaveImage(ShelterHaveImageDto shelterHaveImageDto);

    ShelterHaveImage findByIdShelterHaveImage(Long id);

    List<ShelterHaveImage> findAllShelterHaveImages();

    void deleteByIdShelterHaveImage(Long id);
}
