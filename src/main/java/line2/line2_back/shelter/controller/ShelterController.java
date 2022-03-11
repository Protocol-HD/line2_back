package line2.line2_back.shelter.controller;

import line2.line2_back.shelter.model.Shelter;

import java.util.List;

public interface ShelterController {
    Shelter addShelter(Shelter shelter);

    Shelter editShelter(Shelter shelter);

    Shelter findByIdShelter(Long id);

    List<Shelter> findAllShelter();

    void deleteByIdShelter(Long id);
}
