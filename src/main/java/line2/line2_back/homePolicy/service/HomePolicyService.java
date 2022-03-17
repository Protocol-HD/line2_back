package line2.line2_back.homePolicy.service;

import line2.line2_back.homePolicy.model.HomePolicy;

public interface HomePolicyService {
    HomePolicy save(HomePolicy homePolicy);

    void deleteById(Long id);
}
