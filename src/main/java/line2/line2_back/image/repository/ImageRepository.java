package line2.line2_back.image.repository;

import line2.line2_back.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
