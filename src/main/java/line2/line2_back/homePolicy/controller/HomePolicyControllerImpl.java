package line2.line2_back.homePolicy.controller;

import line2.line2_back.homePolicy.model.HomePolicy;
import line2.line2_back.homePolicy.service.HomePolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class HomePolicyControllerImpl implements HomePolicyController{
    private final HomePolicyService homePolicyService;

    @Override
    @PostMapping("/v1/home_policy")
    public HomePolicy add(@RequestBody HomePolicy homePolicy) {
        try {
            log.info("HomePolicyController add HomePolicy({}) start", homePolicy);
            return homePolicyService.save(homePolicy);
        } catch (Exception e) {
            log.error("HomePolicyController add HomePolicy failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyController add HomePolicy end");
        }
    }

    @Override
    @PutMapping("/v1/home_policy")
    public HomePolicy edit(@RequestBody HomePolicy homePolicy) {
        try {
            log.info("HomePolicyController edit HomePolicy({}) start", homePolicy);
            return homePolicyService.save(homePolicy);
        } catch (Exception e) {
            log.error("HomePolicyController edit HomePolicy failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyController edit HomePolicy end");
        }
    }

    @Override
    @DeleteMapping("/v1/home_policy/{id}")
    public void delete(@PathVariable Long id) {
        try {
            log.info("HomePolicyController delete by id HomePolicy({}) start", id);
            homePolicyService.deleteById(id);
        } catch (Exception e) {
            log.error("HomePolicyController delete by id HomePolicy failure, error: {}", e.getMessage());
        } finally {
            log.info("HomePolicyController delete by id HomePolicy end");
        }
    }
}
