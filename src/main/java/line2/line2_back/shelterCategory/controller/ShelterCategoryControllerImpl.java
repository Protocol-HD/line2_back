package line2.line2_back.shelterCategory.controller;

import line2.line2_back.shelterCategory.model.ShelterCategory;
import line2.line2_back.shelterCategory.service.ShelterCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ShelterCategoryControllerImpl implements ShelterCategoryController {
    private final ShelterCategoryService shelterCategoryService;

    @Override
    @PostMapping("/addShelterCategory")
    public ShelterCategory addShelterCategory(@RequestBody ShelterCategory shelterCategory) {
        try {
            log.info("ShelterCategoryController add shelterCategory({}) start", shelterCategory);
            return shelterCategoryService.saveShelterCategory(shelterCategory);
        } catch (Exception e) {
            log.error("ShelterCategoryController add shelterCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterCategoryController add shelterCategory end");
        }
    }

    @Override
    @PutMapping("/editShelterCategory")
    public ShelterCategory editShelterCategory(@RequestBody ShelterCategory shelterCategory) {
        try {
            log.info("ShelterCategoryController edit shelterCategory({}) start", shelterCategory);
            return shelterCategoryService.saveShelterCategory(shelterCategory);
        } catch (Exception e) {
            log.error("ShelterCategoryController edit shelterCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterCategoryController edit shelterCategory end");
        }
    }

    @Override
    @GetMapping("/findShelterCategory/{id}")
    public ShelterCategory findByIdShelterCategory(@PathVariable Long id) {
        try {
            log.info("ShelterCategoryController find by id shelterCategory(id: {}) start", id);
            return shelterCategoryService.findByIdShelterCategory(id);
        } catch (Exception e) {
            log.error("ShelterCategoryController find by id shelterCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterCategoryController find by id shelterCategory end");
        }
    }

    @Override
    @GetMapping("/findAllShelterCategories")
    public List<ShelterCategory> findAllShelterCategories() {
        try {
            log.info("ShelterCategoryController find all shelterCategories start");
            return shelterCategoryService.findAllShelterCategories();
        } catch (Exception e) {
            log.error("ShelterCategoryController find all shelterCategories failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterCategoryController find all shelterCategories end");
        }
    }

    @Override
    @DeleteMapping("/deleteShelterCategory/{id}")
    public void deleteByIdShelterCategory(@PathVariable Long id) {
        try {
            log.info("ShelterCategoryController delete by id shelterCategory(id: {}) start", id);
            shelterCategoryService.deleteByIdShelterCategory(id);
        } catch (Exception e) {
            log.error("ShelterCategoryController delete by id shelterCategory failure, error: {}", e.getMessage());
        } finally {
            log.info("ShelterCategoryController delete by id shelterCategory end");
        }
    }
}
