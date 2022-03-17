package line2.line2_back.home.service;

import line2.line2_back.home.model.Home;

import java.util.List;

public interface HomeService {
    Home saveHome(Home home);

    Home findByIdHome(Long id);

    List<Home> findAllHome();

    void deleteByIdHome(Long id);
}
