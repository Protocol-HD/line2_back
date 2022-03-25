package line2.line2_back.home.controller;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.model.HomeDto;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.List;

public interface HomeController {
    SystemMessage add(HomeDto homeDto);

    SystemMessage edit(HomeDto homeDto);

    HomeDto findById(Long id);

    List<Home> findAll();

    SystemMessage deleteById(Long id);

    List<Home> findByHomeAddress(String homeAddress);
}
