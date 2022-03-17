package line2.line2_back.homeFacility.controller;

import line2.line2_back.homeFacility.model.HomeFacility;

import java.util.List;

public interface HomeFacilityController {
    HomeFacility findByIdHomeFacility(Long id);

    List<HomeFacility> findAllHomeFacility();
}
