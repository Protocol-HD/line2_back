package line2.line2_back.homeFacility.service;

import line2.line2_back.homeFacility.model.HomeFacility;
import line2.line2_back.homeFacility.repository.HomeFacilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeFacilityServiceImpl implements HomeFacilityService{
    private final HomeFacilityRepository homeFacilityRepository;

    @Override
    public HomeFacility findByIdHomeFacility(Long id) {
        try {
            log.info("HomeFacilityService find by id HomeFacility(id: {}) start", id);
            return homeFacilityRepository.findById(id).get();
        } catch (Exception e) {
            log.error("HomeFacilityService find by id HomeFacility failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityService find by id HomeFacility end");
        }
    }

    @Override
    public List<HomeFacility> findAllHomeFacility() {
        try {
            log.info("HomeFacilityService find all HomeFacilities start");
            return homeFacilityRepository.findAll();
        } catch (Exception e) {
            log.error("HomeFacilityService find all HomeFacilities failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityService find all HomeFacilities end");
        }
    }
}
