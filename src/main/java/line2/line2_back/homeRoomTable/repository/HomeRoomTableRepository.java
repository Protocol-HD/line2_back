package line2.line2_back.homeRoomTable.repository;

import line2.line2_back.homeRoomTable.model.HomeRoomTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRoomTableRepository extends JpaRepository<HomeRoomTable, Long> {
    List<HomeRoomTable> findByHomeId(Long id);
}
