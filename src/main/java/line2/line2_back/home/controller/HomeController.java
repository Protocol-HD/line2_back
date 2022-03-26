package line2.line2_back.home.controller;

import line2.line2_back.home.model.HomeDto;
import line2.line2_back.home.model.HomeListDto;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.List;

public interface HomeController {
    SystemMessage add(HomeDto homeDto);

    SystemMessage edit(HomeDto homeDto);

    HomeDto findById(Long id);

    List<HomeListDto> findAll();

    SystemMessage deleteById(Long id);

    List<HomeListDto> findByHomeAddress(String homeAddress);
}
