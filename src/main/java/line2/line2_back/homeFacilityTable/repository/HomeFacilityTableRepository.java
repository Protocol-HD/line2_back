package line2.line2_back.homeFacilityTable.repository;

import line2.line2_back.homeFacilityTable.model.HomeFacilityTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeFacilityTableRepository extends JpaRepository<HomeFacilityTable, Long> {
    List<HomeFacilityTable> findByHomeId(Long id);
}
