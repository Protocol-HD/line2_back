package line2.line2_back.image.service;

import line2.line2_back.image.model.Image;

import java.util.List;

public interface ImageService {
    Image saveImage(Image image);

    Image findByIdImage(Long id);

    List<Image> findAllImages();

    void deleteByIdImage(Long id);
}
