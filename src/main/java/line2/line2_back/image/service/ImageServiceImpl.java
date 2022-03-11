package line2.line2_back.image.service;

import line2.line2_back.image.model.Image;
import line2.line2_back.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private static ImageRepository imageRepository;

    @Override
    public Image saveImage(Image image) {
        try {
            log.info("ImageService save image({}) start", image);
            return imageRepository.save(image);
        } catch (Exception e) {
            log.error("ImageService save image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageService save image end");
        }
    }

    @Override
    public Image findByIdImage(Long id) {
        try {
            log.info("ImageService find by id image(id: {}) start", id);
            return imageRepository.findById(id).get();
        } catch (Exception e) {
            log.error("ImageService find by id image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageService find by id image end");
        }
    }

    @Override
    public List<Image> findAllImages() {
        try {
            log.info("ImageService find all images start");
            return imageRepository.findAll();
        } catch (Exception e) {
            log.error("ImageService find all images failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageService find all images end");
        }
    }

    @Override
    public void deleteByIdImage(Long id) {
        try {
            log.info("ImageService delete by id image(id: {}) start", id);
            imageRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ImageService delete by id image failure, error: {}", e.getMessage());
        } finally {
            log.info("ImageService delete by id image end");
        }
    }
}