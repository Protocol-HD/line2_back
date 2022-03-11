package line2.line2_back.shelterHaveImage.controller;

import line2.line2_back.shelterHaveImage.model.ShelterHaveImage;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDtoInput;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDtoOutput;

import java.util.List;

public interface ShelterHaveImageController {
    ShelterHaveImage addShelterHaveImage(ShelterHaveImageDtoInput shelterHaveImageDtoInput);

    ShelterHaveImage editShelterHaveImage(ShelterHaveImageDtoInput shelterHaveImageDtoInput);

    ShelterHaveImageDtoOutput findByIdShelterHaveImage(Long id);

    List<ShelterHaveImageDtoOutput> findAllShelterHaveImages();

    void deleteByIdShelterHaveImage(Long id);

    List<ShelterHaveImageDtoOutput> findByShelterId(Long id);
}
