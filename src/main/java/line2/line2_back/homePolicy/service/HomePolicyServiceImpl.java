package line2.line2_back.homePolicy.service;

import line2.line2_back.homePolicy.model.HomePolicy;
import line2.line2_back.homePolicy.repository.HomePolicyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomePolicyServiceImpl implements HomePolicyService{
    private final HomePolicyRepository homePolicyRepository;

    @Override
    public HomePolicy save(HomePolicy homePolicy) {
        try {
            log.info("HomePolicyService save HomePolicy({}) start", homePolicy);
            return homePolicyRepository.save(homePolicy);
        } catch (Exception e) {
            log.error("HomePolicyService save HomePolicy failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyService save HomePolicy end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("HomePolicyService delete by id HomePolicy(id: {}) start", id);
            homePolicyRepository.deleteById(id);
        } catch (Exception e) {
            log.error("HomePolicyService delete by id HomePolicy failure, error: {}", e.getMessage());
        } finally {
            log.info("HomePolicyService delete by id HomePolicy end");
        }
    }
}
