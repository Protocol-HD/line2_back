package line2.line2_back.shelterHaveImage.service;

import line2.line2_back.image.repository.ImageRepository;
import line2.line2_back.shelter.repository.ShelterRepository;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImage;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDtoInput;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDtoOutput;
import line2.line2_back.shelterHaveImage.repository.ShelterHaveImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShelterHaveImageServiceImpl implements ShelterHaveImageService {
    private final ShelterHaveImageRepository shelterHaveImageRepository;
    private final ImageRepository imageRepository;
    private final ShelterRepository shelterRepository;

    @Override
    public ShelterHaveImage saveShelterHaveImage(ShelterHaveImageDtoInput shelterHaveImageDtoInput) {
        try {
            log.info("ShelterHaveImageService save shelterHaveImage({}) start", shelterHaveImageDtoInput);
            return shelterHaveImageRepository.save(ShelterHaveImage.builder()
                    .id(shelterHaveImageDtoInput.getId())
                    .image(imageRepository.findById(shelterHaveImageDtoInput.getImageId()).get())
                    .shelter(shelterRepository.findById(shelterHaveImageDtoInput.getShelterId()).get())
                    .build());
        } catch (Exception e) {
            log.error("ShelterHaveImageService save shelterHaveImage failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterHaveImageService save shelterHaveImage end");
        }
    }

    @Override
    public ShelterHaveImageDtoOutput findByIdShelterHaveImage(Long id) {
        try {
            log.info("ShelterHaveImageService find by id shelterHaveImage(id: {}) start", id);
            return ShelterHaveImageDtoOutput.builder()
                    .imageName(shelterHaveImageRepository.findById(id).get().getImage().getImageName())
                    .build();
        } catch (Exception e) {
            log.error("ShelterHaveImageService find by id shelterHaveImage failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterHaveImageService find by id shelterHaveImage end");
        }
    }

    @Override
    public List<ShelterHaveImageDtoOutput> findAllShelterHaveImages() {
        try {
            log.info("ShelterHaveImageService find all shelterHaveImages start");
            List<ShelterHaveImageDtoOutput> shelterHaveImages = new ArrayList<>();
            log.info("ShelterHaveImageService modify DtoOutput");
            shelterHaveImageRepository.findAll().forEach(shelterHaveImage -> {
                shelterHaveImages.add(ShelterHaveImageDtoOutput.builder()
                        .imageName(shelterHaveImage.getImage().getImageName())
                        .build());
            });
            return shelterHaveImages;
        } catch (Exception e) {
            log.error("ShelterHaveImageService find all shelterHaveImages failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterHaveImageService find all shelterHaveImages end");
        }
    }

    @Override
    public void deleteByIdShelterHaveImage(Long id) {
        try {
            log.info("ShelterHaveImageService delete by id shelterHaveImage(id: {}) start", id);
            shelterHaveImageRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ShelterHaveImageService delete by id shelterHaveImage failure, error: {}", e.getMessage());
        } finally {
            log.info("ShelterHaveImageService delete by id shelterHaveImage end");
        }
    }

    @Override
    public List<ShelterHaveImageDtoOutput> findByShelterId(Long id) {
        try {
            log.info("ShelterHaveImageService find by shelter id shelterHaveImages(id: {}) start", id);
            List<ShelterHaveImageDtoOutput> shelterHaveImages = new ArrayList<>();
            log.info("ShelterHaveImageService modify DtoOutput");
            shelterHaveImageRepository.findByShelterId(id).forEach(shelterHaveImage -> {
                shelterHaveImages.add(ShelterHaveImageDtoOutput.builder()
                        .imageName(shelterHaveImage.getImage().getImageName())
                        .build());
            });
            return shelterHaveImages;
        } catch (Exception e) {
            log.error("ShelterHaveImageService find shelter id shelterHaveImages failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterHaveImageService find shelter id shelterHaveImages end");
        }
    }
}
