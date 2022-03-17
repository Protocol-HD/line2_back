package line2.line2_back.homeFacility.controller;

import line2.line2_back.homeFacility.model.HomeFacility;
import line2.line2_back.homeFacility.service.HomeFacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class HomeFacilityControllerImpl implements HomeFacilityController{
    private final HomeFacilityService homeFacilityService;

    @Override
    @GetMapping("/v1/home_facility/get/{id}")
    public HomeFacility findByIdHomeFacility(@PathVariable Long id) {
        try {
            log.info("HomeFacilityController find by id HomeFacility(id: {}) start", id);
            return homeFacilityService.findByIdHomeFacility(id);
        } catch (Exception e) {
            log.error("HomeFacilityController find by id HomeFacility failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityController find by id HomeFacility end");
        }
    }

    @Override
    @GetMapping("/v1/home_facility/get_list")
    public List<HomeFacility> findAllHomeFacility() {
        try {
            log.info("HomeFacilityController find all HomeFacilities start");
            return homeFacilityService.findAllHomeFacility();
        } catch (Exception e) {
            log.error("HomeFacilityController find all HomeFacilities failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityController find all HomeFacilities end");
        }
    }
}
