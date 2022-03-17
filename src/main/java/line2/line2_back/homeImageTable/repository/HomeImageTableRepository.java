package line2.line2_back.homeImageTable.repository;

import line2.line2_back.homeImageTable.model.HomeImageTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeImageTableRepository extends JpaRepository<HomeImageTable, Long> {
    List<HomeImageTable> findByHomeId(Long id);
}
