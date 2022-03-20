package line2.line2_back.homePolicy.service;

import line2.line2_back.homePolicy.model.HomePolicy;

import java.util.List;

public interface HomePolicyService {
    HomePolicy save(HomePolicy homePolicy);

    void deleteById(Long id);

    List<HomePolicy> getInPolicies();

    List<HomePolicy> getOutPolicies();
}
