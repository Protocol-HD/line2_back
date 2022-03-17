package line2.line2_back.home.controller;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.service.HomeService;
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
    public Home addHome(@RequestBody Home home) {
        try {
            log.info("HomeController add Home({}) start", home);
            return homeService.saveHome(home);
        } catch (Exception e) {
            log.error("HomeController add Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController add Home end");
        }
    }

    @Override
    @PostMapping("/v1/home/edit")
    public Home editHome(@RequestBody Home home) {
        try {
            log.info("HomeController edit Home({}) start", home);
            return homeService.saveHome(home);
        } catch (Exception e) {
            log.error("HomeController edit Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController edit Home end");
        }
    }

    @Override
    @GetMapping("/v1/home/get/{id}")
    public Home findByIdHome(@PathVariable Long id) {
        try {
            log.info("HomeController find by id Home({}) start", id);
            return homeService.findByIdHome(id);
        } catch (Exception e) {
            log.error("HomeController find by id Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController find by id Home end");
        }
    }

    @Override
    @GetMapping("/v1/home/get_list")
    public List<Home> findAllHome() {
        try {
            log.info("HomeController find all Homes start");
            return homeService.findAllHome();
        } catch (Exception e) {
            log.error("HomeController find all Homes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController find all Homes end");
        }
    }

    @Override
    @DeleteMapping("/v1/home/delete/{id}")
    public void deleteByIdHome(@PathVariable Long id) {
        try {
            log.info("HomeController delete by id Home({}) start", id);
            homeService.deleteByIdHome(id);
        } catch (Exception e) {
            log.error("HomeController delete by id Home failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeController delete by id Home end");
        }
    }
}
