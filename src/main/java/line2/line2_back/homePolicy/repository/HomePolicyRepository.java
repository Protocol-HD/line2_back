package line2.line2_back.homePolicy.repository;

import line2.line2_back.homePolicy.model.HomePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomePolicyRepository extends JpaRepository<HomePolicy, Long> {
    List<HomePolicy> findByPolicyType(int type);
}
