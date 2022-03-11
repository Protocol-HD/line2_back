package line2.line2_back.shelterCategory.service;

import line2.line2_back.shelterCategory.model.ShelterCategory;

import java.util.List;

public interface ShelterCategoryService {
    ShelterCategory saveShelterCategory(ShelterCategory shelterCategory);

    ShelterCategory findByIdShelterCategory(Long id);

    List<ShelterCategory> findAllShelterCategories();

    void deleteByIdShelterCategory(Long id);
}
