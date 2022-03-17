package line2.line2_back.homePolicy.repository;

import line2.line2_back.homePolicy.model.HomePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomePolicyRepository extends JpaRepository<HomePolicy, Long> {
}
