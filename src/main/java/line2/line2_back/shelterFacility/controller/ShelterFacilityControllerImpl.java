package line2.line2_back.shelterFacility.controller;

import line2.line2_back.shelterFacility.model.ShelterFacility;
import line2.line2_back.shelterFacility.service.ShelterFacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShelterFacilityControllerImpl implements ShelterFacilityController {
    private final ShelterFacilityService shelterFacilityService;

    @Override
    @PostMapping("/addShelterFacility")
    public ShelterFacility addShelterFacility(@RequestBody ShelterFacility shelterFacility) {
        try {
            log.info("ShelterFacilityController add shelterFacility({}) start", shelterFacility);
            return shelterFacilityService.saveShelterFacility(shelterFacility);
        } catch (Exception e) {
            log.error("ShelterFacilityController add shelterFacility failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterFacilityController add shelterFacility end");
        }
    }

    @Override
    @PutMapping("/editShelterFacility")
    public ShelterFacility editShelterFacility(@RequestBody ShelterFacility shelterFacility) {
        try {
            log.info("ShelterFacilityController edit shelterFacility({}) start", shelterFacility);
            return shelterFacilityService.saveShelterFacility(shelterFacility);
        } catch (Exception e) {
            log.error("ShelterFacilityController edit shelterFacility failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterFacilityController edit shelterFacility end");
        }
    }

    @Override
    @GetMapping("/findShelterFacility/{id}")
    public ShelterFacility findByIdShelterFacility(@PathVariable Long id) {
        try {
            log.info("ShelterFacilityController find by id shelterFacility(id: {}) start", id);
            return shelterFacilityService.findByIdShelterFacility(id);
        } catch (Exception e) {
            log.error("ShelterFacilityController find by id shelterFacility failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterFacilityController find by id shelterFacility end");
        }
    }

    @Override
    @GetMapping("/findAllShelterFacilities")
    public List<ShelterFacility> findAllShelterFacilities() {
        try {
            log.info("ShelterFacilityController find all shelterFacilities start");
            return shelterFacilityService.findAllShelterFacilities();
        } catch (Exception e) {
            log.error("ShelterFacilityController find all shelterFacilities failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterFacilityController find all shelterFacilities end");
        }
    }

    @Override
    @DeleteMapping("/deleteShelterFacility/{id}")
    public void deleteByIdShelterFacility(@PathVariable Long id) {
        try {
            log.info("ShelterFacilityController delete by id shelterFacility(id: {}) start", id);
            shelterFacilityService.deleteByIdShelterFacility(id);
        } catch (Exception e) {
            log.error("ShelterFacilityController delete by id shelterFacility failure, error: {}", e.getMessage());
        } finally {
            log.info("ShelterFacilityController delete by id shelterFacility end");
        }
    }
}
