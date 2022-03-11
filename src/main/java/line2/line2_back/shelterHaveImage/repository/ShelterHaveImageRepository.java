package line2.line2_back.shelterHaveImage.repository;

import line2.line2_back.shelterHaveImage.model.ShelterHaveImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelterHaveImageRepository extends JpaRepository<ShelterHaveImage, Long> {
    List<ShelterHaveImage> findByShelterId(Long id);
}
