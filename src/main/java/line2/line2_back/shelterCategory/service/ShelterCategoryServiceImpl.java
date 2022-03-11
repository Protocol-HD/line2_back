package line2.line2_back.shelterCategory.service;

import line2.line2_back.shelterCategory.model.ShelterCategory;
import line2.line2_back.shelterCategory.repository.ShelterCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShelterCategoryServiceImpl implements ShelterCategoryService{
    private final ShelterCategoryRepository shelterCategoryRepository;

    @Override
    public ShelterCategory saveShelterCategory(ShelterCategory shelterCategory) {
        try {
            log.info("ShelterCategoryService save shelterCategory({}) start", shelterCategory);
            return shelterCategoryRepository.save(shelterCategory);
        } catch (Exception e) {
            log.error("ShelterCategoryService save shelterCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterCategoryService save shelterCategory end");
        }
    }

    @Override
    public ShelterCategory findByIdShelterCategory(Long id) {
        try {
            log.info("ShelterCategoryService find by id shelterCategory(id: {}) start", id);
            return shelterCategoryRepository.findById(id).get();
        } catch (Exception e) {
            log.error("ShelterCategoryService find by id shelterCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterCategoryService find by id shelterCategory end");
        }
    }

    @Override
    public List<ShelterCategory> findAllShelterCategories() {
        try {
            log.info("ShelterCategoryService find all shelterCategories start");
            return shelterCategoryRepository.findAll();
        } catch (Exception e) {
            log.error("ShelterCategoryService find all shelterCategories failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterCategoryService find all shelterCategories end");
        }
    }

    @Override
    public void deleteByIdShelterCategory(Long id) {
        try {
            log.info("ShelterCategoryService delete by id shelterCategory(id: {}) start", id);
            shelterCategoryRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ShelterCategoryService delete by id shelterCategory failure, error: {}", e.getMessage());
        } finally {
            log.info("ShelterCategoryService delete by id shelterCategory end");
        }
    }
}
