package line2.line2_back.home.controller;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.model.HomeDto;
import line2.line2_back.home.service.HomeService;
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
public class HomeControllerImpl implements HomeController {
    private final HomeService homeService;

    @Override
    @PostMapping("/v1/home")
    public SystemMessage add(@RequestBody HomeDto homeDto) {
        try {
            log.info("HomeController add Home({}) start", homeDto);
            return homeService.add(homeDto);
        } catch (Exception e) {
            log.error("HomeController add Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 등록 실패")
                    .build();
        } finally {
            log.info("HomeController add Home end");
        }
    }

    @Override
    @PutMapping("/v1/home")
    public SystemMessage edit(@RequestBody HomeDto homeDto) {
        try {
            log.info("HomeController edit Home(id: {}) start", homeDto);
            return homeService.edit(homeDto);
        } catch (Exception e) {
            log.error("HomeController edit Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 정보 변경 실패")
                    .build();
        } finally {
            log.info("HomeController edit Home end");
        }
    }

    @Override
    @GetMapping("/v1/home/{id}")
    public HomeDto findById(@PathVariable Long id) {
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
    @GetMapping("/v1/home/list")
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
    @DeleteMapping("/v1/home/{id}")
    public SystemMessage deleteById(@PathVariable Long id) {
        try {
            log.info("HomeController delete by id Home(id: {}) start", id);
            return homeService.deleteById(id);
        } catch (Exception e) {
            log.error("HomeController delete by id Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 삭제 실패")
                    .build();
        } finally {
            log.info("HomeController delete by id Home end");
        }
    }

    @Override
    @GetMapping("/v1/home/find/{homeAddress}")
    public List<Home> findByHomeAddress(@PathVariable String homeAddress) {
        try {
            log.info("HomeController find by home address Homes(homeAddress: {}) start", homeAddress);
            return homeService.findByHomeAddress(homeAddress);
        } catch (Exception e) {
            log.error("HomeController find by home address Homes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeController find by home address Homes end");
        }
    }
}
