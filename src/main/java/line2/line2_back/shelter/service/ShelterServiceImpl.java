package line2.line2_back.shelter.service;

import line2.line2_back.shelter.model.Shelter;
import line2.line2_back.shelter.repository.ShelterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService {
    private final ShelterRepository shelterRepository;

    @Override
    public Shelter saveShelter(Shelter shelter) {
        try {
            log.info("ShelterService save shelter({}) start", shelter);
            return shelterRepository.save(shelter);
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
