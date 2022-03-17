package line2.line2_back.home.controller;

import line2.line2_back.home.model.Home;

import java.util.List;

public interface HomeController {
    Home add(Home home);

    Home edit(Home home);

    Home findById(Long id);

    List<Home> findAll();

    void deleteById(Long id);
}
