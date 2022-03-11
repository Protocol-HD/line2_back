package line2.line2_back.shelterFacility.controller;

import line2.line2_back.shelterFacility.model.ShelterFacility;

import java.util.List;

public interface ShelterFacilityController {
    ShelterFacility addShelterFacility(ShelterFacility shelterFacility);

    ShelterFacility editShelterFacility(ShelterFacility shelterFacility);

    ShelterFacility findByIdShelterFacility(Long id);

    List<ShelterFacility> findAllShelterFacilities();

    void deleteByIdShelterFacility(Long id);
}
