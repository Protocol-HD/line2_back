package line2.line2_back.homeCategory.controller;

import line2.line2_back.homeCategory.model.HomeCategory;

import java.util.List;

public interface HomeCategoryController {
    HomeCategory findById(Long id);

    List<HomeCategory> findAll();
}
