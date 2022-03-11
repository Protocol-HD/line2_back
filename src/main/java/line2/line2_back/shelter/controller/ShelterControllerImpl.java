package line2.line2_back.shelter.controller;

import line2.line2_back.shelter.model.Shelter;
import line2.line2_back.shelter.service.ShelterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class ShelterControllerImpl implements ShelterController{
    private final ShelterService shelterService;

    @Override
    @PostMapping("/addShelter")
    public Shelter addShelter(@RequestBody Shelter shelter) {
        try {
            log.info("ShelterController add shelter({}) start", shelter);
            return shelterService.saveShelter(shelter);
        } catch (Exception e) {
            log.error("ShelterController add shelter failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterController add shelter end");
        }
    }

    @Override
    @PutMapping("/editShelter")
    public Shelter editShelter(@RequestBody Shelter shelter) {
        try {
            log.info("ShelterController edit shelter({}) start", shelter);
            return shelterService.saveShelter(shelter);
        } catch (Exception e) {
            log.error("ShelterController edit shelter failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterController edit shelter end");
        }
    }

    @Override
    @GetMapping("/findShelter/{id}")
    public Shelter findByIdShelter(@PathVariable Long id) {
        try {
            log.info("ShelterController find by id shelter(id: {}) start", id);
            return shelterService.findByIdShelter(id);
        } catch (Exception e) {
            log.error("ShelterController find by id shelter failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterController find by id shelter end");
        }
    }

    @Override
    @GetMapping("/findAllShelter")
    public List<Shelter> findAllShelter() {
        try {
            log.info("ShelterController find all shelters start");
            return shelterService.findAllShelter();
        } catch (Exception e) {
            log.error("ShelterController find all shelters failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ShelterController find all shelters end");
        }
    }

    @Override
    @DeleteMapping("/deleteShelter/{id}")
    public void deleteByIdShelter(@PathVariable Long id) {
        try {
            log.info("ShelterController delete by id shelter(id: {}) start", id);
            shelterService.deleteByIdShelter(id);
        } catch (Exception e) {
            log.error("ShelterController delete by id shelter failure, error: {}", e.getMessage());
        } finally {
            log.info("ShelterController delete by id shelter end");
        }
    }
}
