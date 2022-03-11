package line2.line2_back.shelterHaveImage.service;

import line2.line2_back.shelterHaveImage.model.ShelterHaveImage;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDtoInput;

import java.util.List;

public interface ShelterHaveImageService {
    ShelterHaveImage saveShelterHaveImage(ShelterHaveImageDtoInput shelterHaveImageDtoInput);

    ShelterHaveImage findByIdShelterHaveImage(Long id);

    List<ShelterHaveImage> findAllShelterHaveImages();

    void deleteByIdShelterHaveImage(Long id);
}
