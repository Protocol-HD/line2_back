package line2.line2_back.shelterHaveImage.controller;

import line2.line2_back.shelterHaveImage.model.ShelterHaveImage;

import java.util.List;

public interface ShelterHaveImageController {
    ShelterHaveImage addShelterHaveImage(ShelterHaveImage shelterHaveImage);

    ShelterHaveImage editShelterHaveImage(ShelterHaveImage shelterHaveImage);

    ShelterHaveImage findByIdShelterHaveImage(Long id);

    List<ShelterHaveImage> findAllShelterHaveImages();

    void deleteByIdShelterHaveImage(Long id);
}
