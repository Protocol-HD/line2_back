package line2.line2_back.homeCategory.controller;

import line2.line2_back.homeCategory.model.HomeCategory;
import line2.line2_back.homeCategory.service.HomeCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class HomeCategoryControllerImpl implements HomeCategoryController{
    private final HomeCategoryService homeCategoryService;

    @Override
    @GetMapping("/v1/homeCategory/get/{id}")
    public HomeCategory findByIdHomeCategory(@PathVariable Long id) {
        try {
            log.info("HomeCategoryController find by id HomeCategory(id: {}) start", id);
            return homeCategoryService.findByIdHomeCategory(id);
        } catch (Exception e) {
            log.error("HomeCategoryController find by id HomeCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeCategoryController find by id HomeCategory end");
        }
    }

    @Override
    @GetMapping("/v1/homeCategory/get_list")
    public List<HomeCategory> findAllHomeCategory() {
        try {
            log.info("HomeCategoryController find all HomeCategories start");
            return homeCategoryService.findAllHomeCategory();
        } catch (Exception e) {
            log.error("HomeCategoryController find all HomeCategories failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeCategoryController find all HomeCategories end");
        }
    }
}
