package line2.line2_back.shelter.service;

import line2.line2_back.shelter.model.Shelter;

import java.util.List;

public interface ShelterService {
    Shelter saveShelter(Shelter shelter);

    Shelter findByIdShelter(Long id);

    List<Shelter> findAllShelter();

    void deleteByIdShelter(Long id);
}
