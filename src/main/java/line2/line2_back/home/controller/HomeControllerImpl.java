package line2.line2_back.home.controller;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.model.HomeDtoInput;
import line2.line2_back.home.service.HomeService;
import line2.line2_back.homeFacility.service.HomeFacilityService;
import line2.line2_back.homeFacilityTable.service.HomeFacilityTableService;
import line2.line2_back.homeImageTable.service.HomeImageTableService;
import line2.line2_back.homePolicy.service.HomePolicyService;
import line2.line2_back.homePolicyTable.service.HomePolicyTableService;
import line2.line2_back.homeRoomTable.service.HomeRoomTableService;
import line2.line2_back.image.service.ImageService;
import line2.line2_back.room.service.RoomService;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class HomeControllerImpl implements HomeController{
    private final HomeService homeService;

    @Override
    @PostMapping("/v1/home/add")
    public SystemMessage add(@RequestBody HomeDtoInput homeDtoInput) {
        try {
            log.info("HomeController add Home({}) start", homeDtoInput);
            return homeService.save(homeDtoInput);
        } catch (Exception e) {
            log.error("HomeController add Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController add Home end");
        }
    }

    @Override
    @PutMapping("/v1/home/edit")
    public SystemMessage edit(@RequestBody HomeDtoInput homeDtoInput) {
        try {
            log.info("HomeController edit Home(id: {}) start", homeDtoInput);
            return homeService.save(homeDtoInput);
        } catch (Exception e) {
            log.error("HomeController edit Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController edit Home end");
        }
    }

    @Override
    @GetMapping("/v1/home/get/{id}")
    public Home findById(@PathVariable Long id) {
        try {
            log.info("HomeController find by id Home(id: {}) start", id);
            return homeService.findById(id);
        } catch (Exception e) {
            log.error("HomeController find by id Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController find by id Home end");
        }
    }

    @Override
    @GetMapping("/v1/home/get_list")
    public List<Home> findAll() {
        try {
            log.info("HomeController find all Homes start");
            return homeService.findAll();
        } catch (Exception e) {
            log.error("HomeController find all Homes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController find all Homes end");
        }
    }

    @Override
    @DeleteMapping("/v1/home/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            log.info("HomeController delete by id Home(id: {}) start", id);
            homeService.deleteById(id);
        } catch (Exception e) {
            log.error("HomeController delete by id Home failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeController delete by id Home end");
        }
    }
}
