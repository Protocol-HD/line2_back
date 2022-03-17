package line2.line2_back.image.service;

import line2.line2_back.image.model.Image;

import java.util.List;

public interface ImageService {
    Image save(Image image);

    Image findById(Long id);

    List<Image> findAll();

    void deleteById(Long id);
}
