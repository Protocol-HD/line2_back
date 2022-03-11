package line2.line2_back.shelterFacility.service;

import line2.line2_back.shelterFacility.model.ShelterFacility;

import java.util.List;

public interface ShelterFacilityService {
    ShelterFacility saveShelterFacility(ShelterFacility shelterFacility);

    ShelterFacility findByIdShelterFacility(Long id);

    List<ShelterFacility> findAllShelterFacilities();

    void deleteByIdShelterFacility(Long id);
}
