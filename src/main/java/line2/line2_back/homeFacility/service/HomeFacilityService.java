package line2.line2_back.homeFacility.service;

import line2.line2_back.homeFacility.model.HomeFacility;

import java.util.List;

public interface HomeFacilityService {
    HomeFacility findByIdHomeFacility(Long id);

    List<HomeFacility> findAllHomeFacility();
}
