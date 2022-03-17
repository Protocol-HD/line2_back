package line2.line2_back.image.controller;

import line2.line2_back.image.model.Image;
import line2.line2_back.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class ImageControllerImpl implements ImageController {
    private final ImageService imageService;

    @Override
    @PostMapping("/v1/image/add")
    public Image addImage(@RequestBody Image image) {
        try {
            log.info("ImageController add Image({}) start", image);
            return imageService.saveImage(image);
        } catch (Exception e) {
            log.error("ImageController add Image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController add Image end");
        }
    }

    @Override
    @PutMapping("/v1/image/edit")
    public Image editImage(@RequestBody Image image) {
        try {
            log.info("ImageController edit Image({}) start", image);
            return imageService.saveImage(image);
        } catch (Exception e) {
            log.error("ImageController edit Image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController edit Image end");
        }
    }

    @Override
    @GetMapping("/v1/image/get/{id}")
    public Image findByIdImage(@PathVariable Long id) {
        try {
            log.info("ImageController find by id Image(id: {}) start", id);
            return imageService.findByIdImage(id);
        } catch (Exception e) {
            log.error("ImageController find by id Image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController find by id Image end");
        }
    }

    @Override
    @GetMapping("/v1/image/get_list")
    public List<Image> findAllImages() {
        try {
            log.info("ImageController find all Images start");
            return imageService.findAllImages();
        } catch (Exception e) {
            log.error("ImageController find all Images failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController find all Images end");
        }
    }

    @Override
    @DeleteMapping("/v1/image/delete/{id}")
    public void deleteByIdImage(@PathVariable Long id) {
        try {
            log.info("ImageController delete by id Image(id: {}) start", id);
            imageService.deleteByIdImage(id);
        } catch (Exception e) {
            log.error("ImageController delete by id Image failure, error: {}", e.getMessage());
        } finally {
            log.info("ImageController delete by id Image end");
        }
    }
}
