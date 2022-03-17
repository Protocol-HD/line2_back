package line2.line2_back.homeCategory.service;

import line2.line2_back.homeCategory.model.HomeCategory;
import line2.line2_back.homeCategory.repository.HomeCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeCategoryServiceImpl implements HomeCategoryService{
    private final HomeCategoryRepository homeCategoryRepository;

    @Override
    public HomeCategory findByIdHomeCategory(Long id) {
        try {
            log.info("HomeCategoryService find by id HomeCategory(id: {}) start", id);
            return homeCategoryRepository.findById(id).get();
        } catch (Exception e) {
            log.error("HomeCategoryService find by id HomeCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeCategoryService find by id HomeCategory end");
        }
    }

    @Override
    public List<HomeCategory> findAllHomeCategory() {
        try {
            log.info("HomeCategoryService find all HomeCategories start");
            return homeCategoryRepository.findAll();
        } catch (Exception e) {
            log.error("HomeCategoryService find all HomeCategories failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeCategoryService find all HomeCategories end");
        }
    }
}
