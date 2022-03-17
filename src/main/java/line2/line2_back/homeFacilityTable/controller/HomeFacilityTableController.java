package line2.line2_back.homeFacilityTable.controller;

import line2.line2_back.homeFacilityTable.model.HomeFacilityTable;

import java.util.List;

public interface HomeFacilityTableController {
    HomeFacilityTable add(HomeFacilityTable homeFacilityTable);

    HomeFacilityTable edit(HomeFacilityTable homeFacilityTable);

    void deleteById(Long id);

    List<HomeFacilityTable> findByHomeId(Long id);
}
