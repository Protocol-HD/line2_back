package line2.line2_back.homeRoomTable.service;

import line2.line2_back.homeRoomTable.model.HomeRoomTable;

import java.util.List;

public interface HomeRoomTableService {
    HomeRoomTable save(HomeRoomTable homeRoomTable);

    void deleteById(Long id);

    List<HomeRoomTable> findByHomeId(Long id);
}
