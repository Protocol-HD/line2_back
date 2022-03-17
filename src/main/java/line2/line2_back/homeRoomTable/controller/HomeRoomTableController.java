package line2.line2_back.homeRoomTable.controller;

import line2.line2_back.homeRoomTable.model.HomeRoomTable;

import java.util.List;

public interface HomeRoomTableController {
    HomeRoomTable add(HomeRoomTable homeRoomTable);

    HomeRoomTable edit(HomeRoomTable homeRoomTable);

    void deleteById(Long id);

    List<HomeRoomTable> findByHomeId(Long id);
}
