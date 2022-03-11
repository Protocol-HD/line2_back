package line2.line2_back.shelterCategory.controller;

import line2.line2_back.shelterCategory.model.ShelterCategory;

import java.util.List;

public interface ShelterCategoryController {
    ShelterCategory addShelterCategory(ShelterCategory shelterCategory);

    ShelterCategory editShelterCategory(ShelterCategory shelterCategory);

    ShelterCategory findByIdShelterCategory(Long id);

    List<ShelterCategory> findAllShelterCategories();

    void deleteByIdShelterCategory(Long id);
}
