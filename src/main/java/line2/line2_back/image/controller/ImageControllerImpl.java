package line2.line2_back.image.controller;

import line2.line2_back.image.model.Image;
import line2.line2_back.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class ImageControllerImpl implements ImageController {
    private static ImageService imageservice;

    @Override
    public Image addImage(Image image) {
        try {
            log.info("ImageController add image({}) start", image);
            return imageservice.saveImage(image);
        } catch (Exception e) {
            log.error("ImageController add image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController add image end");
        }
    }

    @Override
    public Image editImage(Image image) {
        try {
            log.info("ImageController edit image({}) start", image);
            return imageservice.saveImage(image);
        } catch (Exception e) {
            log.error("ImageController edit image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController edit image end");
        }
    }

    @Override
    public Image findByIdImage(Long id) {
        try {
            log.info("ImageController find by id image(id: {}) start", id);
            return imageservice.findByIdImage(id);
        } catch (Exception e) {
            log.error("ImageController find by id image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController find by id image end");
        }
    }

    @Override
    public List<Image> findAllImages() {
        try {
            log.info("ImageController find all images start");
            return imageservice.findAllImages();
        } catch (Exception e) {
            log.error("ImageController find all images failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController find all images end");
        }
    }

    @Override
    public void deleteByIdImage(Long id) {
        try {
            log.info("ImageController delete by id image(id: {}) start", id);
            imageservice.deleteByIdImage(id);
        } catch (Exception e) {
            log.error("ImageController delete by id image failure, error: {}", e.getMessage());
        } finally {
            log.info("ImageController delete by id image end");
        }
    }
}
