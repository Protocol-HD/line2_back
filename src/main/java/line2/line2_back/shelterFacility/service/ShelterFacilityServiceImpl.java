package line2.line2_back.shelterFacility.service;

import line2.line2_back.shelterFacility.model.ShelterFacility;
import line2.line2_back.shelterFacility.repository.ShelterFacilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShelterFacilityServiceImpl implements ShelterFacilityService {
    private final ShelterFacilityRepository shelterFacilityRepository;

    @Override
    public ShelterFacility saveShelterFacility(ShelterFacility shelterFacility) {
        try {
            log.info("ShelterFacilityService save shelterFacility({}) start", shelterFacility);
            return shelterFacilityRepository.save(shelterFacility);
        } catch (Exception e) {
            log.error("ShelterFacilityService save shelterFacility failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterFacilityService save shelterFacility end");
        }
    }

    @Override
    public ShelterFacility findByIdShelterFacility(Long id) {
        try {
            log.info("ShelterFacilityService find by id shelterFacility(id: {}) start", id);
            return shelterFacilityRepository.findById(id).get();
        } catch (Exception e) {
            log.error("ShelterFacilityService find by id shelterFacility failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterFacilityService find by id shelterFacility end");
        }
    }

    @Override
    public List<ShelterFacility> findAllShelterFacilities() {
        try {
            log.info("ShelterFacilityService find all shelterFacilities start");
            return shelterFacilityRepository.findAll();
        } catch (Exception e) {
            log.error("ShelterFacilityService find all shelterFacilities failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterFacilityService find all shelterFacilities end");
        }
    }

    @Override
    public void deleteByIdShelterFacility(Long id) {
        try {
            log.info("ShelterFacilityService delete by id shelterFacility(id: {}) start", id);
            shelterFacilityRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ShelterFacilityService delete by id shelterFacility failure, error: {}", e.getMessage());
        } finally {
            log.info("ShelterFacilityService delete by id shelterFacility end");
        }
    }
}
