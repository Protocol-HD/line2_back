package line2.line2_back.home.controller;

import line2.line2_back.home.model.Home;

import java.util.List;

public interface HomeController {
    Home addHome(Home home);

    Home editHome(Home home);

    Home findByIdHome(Long id);

    List<Home> findAllHome();

    void deleteByIdHome(Long id);
}
