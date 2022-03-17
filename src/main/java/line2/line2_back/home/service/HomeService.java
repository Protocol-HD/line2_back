package line2.line2_back.home.service;

import line2.line2_back.home.model.Home;

import java.util.List;

public interface HomeService {
    Home save(Home home);

    Home findById(Long id);

    List<Home> findAll();

    void deleteById(Long id);
}
