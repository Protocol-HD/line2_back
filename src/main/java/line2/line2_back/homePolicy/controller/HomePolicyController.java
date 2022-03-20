package line2.line2_back.homePolicy.controller;

import line2.line2_back.homePolicy.model.HomePolicy;

import java.util.List;

public interface HomePolicyController {
    HomePolicy add(HomePolicy homePolicy);

    HomePolicy edit(HomePolicy homePolicy);

    void delete(Long id);

    List<HomePolicy> getInPolicies();

    List<HomePolicy> getOutPolicies();
}
