package line2.line2_back.shelterHaveImage.controller;

import line2.line2_back.shelterHaveImage.model.ShelterHaveImage;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDtoInput;
import line2.line2_back.shelterHaveImage.model.ShelterHaveImageDtoOutput;
import line2.line2_back.shelterHaveImage.service.ShelterHaveImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ShelterHaveImageControllerImpl implements ShelterHaveImageController {
    private final ShelterHaveImageService shelterHaveImageService;

    @Override
    @PostMapping("/addShelterHaveImage")
    public ShelterHaveImage addShelterHaveImage(@RequestBody ShelterHaveImageDtoInput shelterHaveImageDtoInput) {
        try {
            log.info("ShelterHaveImageController add shelterHaveImage({}) start", shelterHaveImageDtoInput);
            return shelterHaveImageService.saveShelterHaveImage(shelterHaveImageDtoInput);
        } catch (Exception e) {
            log.error("ShelterHaveImageController add shelterHaveImage failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterHaveImageController add shelterHaveImage end");
        }
    }

    @Override
    @PutMapping("/editShelterHaveImage")
    public ShelterHaveImage editShelterHaveImage(@RequestBody ShelterHaveImageDtoInput shelterHaveImageDtoInput) {
        try {
            log.info("ShelterHaveImageController edit shelterHaveImage({}) start", shelterHaveImageDtoInput);
            return shelterHaveImageService.saveShelterHaveImage(shelterHaveImageDtoInput);
        } catch (Exception e) {
            log.error("ShelterHaveImageController edit shelterHaveImage failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterHaveImageController edit shelterHaveImage end");
        }
    }

    @Override
    @GetMapping("/findShelterHaveImage/{id}")
    public ShelterHaveImageDtoOutput findByIdShelterHaveImage(@PathVariable Long id) {
        try {
            log.info("ShelterHaveImageController find by id shelterHaveImage(id: {}) start", id);
            return shelterHaveImageService.findByIdShelterHaveImage(id);
        } catch (Exception e) {
            log.error("ShelterHaveImageController find by id shelterHaveImage failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterHaveImageController find by id shelterHaveImage end");
        }
    }

    @Override
    @GetMapping("/findAllShelterHaveImages")
    public List<ShelterHaveImage> findAllShelterHaveImages() {
        try {
            log.info("ShelterHaveImageController find all shelterHaveImages start");
            return shelterHaveImageService.findAllShelterHaveImages();
        } catch (Exception e) {
            log.error("ShelterHaveImageController find all shelterHaveImages failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterHaveImageController find all shelterHaveImages end");
        }
    }

    @Override
    @DeleteMapping("/deleteShelterHaveImage/{id}")
    public void deleteByIdShelterHaveImage(@PathVariable Long id) {
        try {
            log.info("ShelterHaveImageController delete by id shelterHaveImage(id: {}) start", id);
            shelterHaveImageService.deleteByIdShelterHaveImage(id);
        } catch (Exception e) {
            log.error("ShelterHaveImageController delete by id shelterHaveImage failure, error: {}", e.getMessage());
        } finally {
            log.info("ShelterHaveImageController delete by id shelterHaveImage end");
        }
    }
}
