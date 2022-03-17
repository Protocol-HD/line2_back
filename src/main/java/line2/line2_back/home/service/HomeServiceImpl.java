package line2.line2_back.home.service;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService{
    private final HomeRepository homeRepository;

    @Override
    public Home saveHome(Home home) {
        try {
            log.info("HomeService save Home({}) start", home);
            return homeRepository.save(home);
        } catch (Exception e) {
            log.error("HomeService save Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService save Home end");
        }
    }

    @Override
    public Home findByIdHome(Long id) {
        try {
            log.info("HomeService find by id Home({}) start", id);
            return homeRepository.findById(id).get();
        } catch (Exception e) {
            log.error("HomeService find by id Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService find by id Home end");
        }
    }

    @Override
    public List<Home> findAllHome() {
        try {
            log.info("HomeService find all Homes start");
            return homeRepository.findAll();
        } catch (Exception e) {
            log.error("HomeService find all Homes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService find all Homes end");
        }
    }

    @Override
    public void deleteByIdHome(Long id) {
        try {
            log.info("HomeService delete by id Home({}) start", id);
            homeRepository.deleteById(id);
        } catch (Exception e) {
            log.error("HomeService delete by id Home failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeService delete by id Home end");
        }
    }
}
