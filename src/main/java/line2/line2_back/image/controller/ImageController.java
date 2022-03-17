package line2.line2_back.image.controller;

import line2.line2_back.image.model.Image;

import java.util.List;

public interface ImageController {
    Image add(Image image);

    Image edit(Image image);

    Image findById(Long id);

    List<Image> findAll();

    void deleteById(Long id);
}
