package line2.line2_back.image.controller;

import line2.line2_back.image.model.Image;
import line2.line2_back.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ImageControllerImpl implements ImageController {
    private final ImageService imageService;

    @Override
    @PostMapping("/addImage")
    public Image addImage(@RequestBody Image image) {
        try {
            log.info("ImageController add image({}) start", image);
            return imageService.saveImage(image);
        } catch (Exception e) {
            log.error("ImageController add image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController add image end");
        }
    }

    @Override
    @PutMapping("/editImage")
    public Image editImage(@RequestBody Image image) {
        try {
            log.info("ImageController edit image({}) start", image);
            return imageService.saveImage(image);
        } catch (Exception e) {
            log.error("ImageController edit image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController edit image end");
        }
    }

    @Override
    @GetMapping("/findImage/{id}")
    public Image findByIdImage(@PathVariable Long id) {
        try {
            log.info("ImageController find by id image(id: {}) start", id);
            return imageService.findByIdImage(id);
        } catch (Exception e) {
            log.error("ImageController find by id image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController find by id image end");
        }
    }

    @Override
    @GetMapping("/findAllImages")
    public List<Image> findAllImages() {
        try {
            log.info("ImageController find all images start");
            return imageService.findAllImages();
        } catch (Exception e) {
            log.error("ImageController find all images failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController find all images end");
        }
    }

    @Override
    @DeleteMapping("/deleteImage/{id}")
    public void deleteByIdImage(@PathVariable Long id) {
        try {
            log.info("ImageController delete by id image(id: {}) start", id);
            imageService.deleteByIdImage(id);
        } catch (Exception e) {
            log.error("ImageController delete by id image failure, error: {}", e.getMessage());
        } finally {
            log.info("ImageController delete by id image end");
        }
    }
}
