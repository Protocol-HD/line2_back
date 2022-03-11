package line2.line2_back.shelter.service;

import line2.line2_back.shelter.model.Shelter;
import line2.line2_back.shelter.model.ShelterDtoInput;
import line2.line2_back.shelter.repository.ShelterRepository;
import line2.line2_back.shelterCategory.repository.ShelterCategoryRepository;
import line2.line2_back.shelterFacility.repository.ShelterFacilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService {
    private final ShelterRepository shelterRepository;
    private final ShelterCategoryRepository shelterCategoryRepository;

    @Override
    public Shelter saveShelter(ShelterDtoInput shelterDtoInput) {
        try {
            log.info("ShelterService save shelter({}) start", shelterDtoInput);
            return shelterRepository.save(Shelter.builder()
                            .id(shelterDtoInput.getId())
                            .shelterName(shelterDtoInput.getShelterName())
                            .shelterAddress(shelterDtoInput.getShelterAddress())
                            .coordinateX(shelterDtoInput.getCoordinateX())
                            .coordinateY(shelterDtoInput.getCoordinateY())
                            .shelterCategory(shelterCategoryRepository.findById(shelterDtoInput.getShelterCategoryId()).get())
                    .build());
        } catch (Exception e) {
            log.error("ShelterService save shelter failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterService save shelter end");
        }
    }

    @Override
    public Shelter findByIdShelter(Long id) {
        try {
            log.info("ShelterService find by id shelter(id: {}) start", id);
            return shelterRepository.findById(id).get();
        } catch (Exception e) {
            log.error("ShelterService find by id shelter failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterService find by id shelter end");
        }
    }

    @Override
    public List<Shelter> findAllShelter() {
        try {
            log.info("ShelterService find all shelters start");
            return shelterRepository.findAll();
        } catch (Exception e) {
            log.error("ShelterService find all shelters failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterService find all shelters end");
        }
    }

    @Override
    public void deleteByIdShelter(Long id) {
        try {
            log.info("ShelterService delete by id shelter(id: {}) start", id);
            shelterRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ShelterService delete by id shelter failure, error: {}", e.getMessage());
        } finally {
            log.info("ShelterService delete by id shelter end");
        }
    }
}
