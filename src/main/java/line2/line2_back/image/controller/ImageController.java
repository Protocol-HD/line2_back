package line2.line2_back.image.controller;

import line2.line2_back.image.model.Image;

import java.util.List;

public interface ImageController {
    Image addImage(Image image);

    Image editImage(Image image);

    Image findByIdImage(Long id);

    List<Image> findAllImages();

    void deleteByIdImage(Long id);
}
