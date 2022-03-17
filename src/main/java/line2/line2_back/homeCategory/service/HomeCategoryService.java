package line2.line2_back.homeCategory.service;

import line2.line2_back.homeCategory.model.HomeCategory;

import java.util.List;

public interface HomeCategoryService {
    HomeCategory findById(Long id);

    List<HomeCategory> findAll();
}
