package line2.line2_back.shelter.controller;

import line2.line2_back.shelter.model.Shelter;
import line2.line2_back.shelter.model.ShelterDtoInput;

import java.util.List;

public interface ShelterController {
    Shelter addShelter(ShelterDtoInput shelterDtoInput);

    Shelter editShelter(ShelterDtoInput shelterDtoInput);

    Shelter findByIdShelter(Long id);

    List<Shelter> findAllShelter();

    void deleteByIdShelter(Long id);
}
