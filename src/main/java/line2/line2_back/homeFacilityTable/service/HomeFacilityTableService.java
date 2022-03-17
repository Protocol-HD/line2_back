package line2.line2_back.homeFacilityTable.service;

import line2.line2_back.homeFacilityTable.model.HomeFacilityTable;

import java.util.List;

public interface HomeFacilityTableService {
    HomeFacilityTable save(HomeFacilityTable homeFacilityTable);

    void deleteById(Long id);

    List<HomeFacilityTable> findByHomeId(Long id);
}
