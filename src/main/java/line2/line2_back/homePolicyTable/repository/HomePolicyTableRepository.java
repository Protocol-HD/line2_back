package line2.line2_back.homePolicyTable.repository;

import line2.line2_back.homePolicyTable.model.HomePolicyTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomePolicyTableRepository extends JpaRepository<HomePolicyTable, Long> {
    List<HomePolicyTable> findByHomeId(Long id);
}
