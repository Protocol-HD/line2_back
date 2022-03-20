package line2.line2_back.home.service;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.model.HomeDtoInput;
import line2.line2_back.systemMessage.SystemMessage;

import java.util.List;

public interface HomeService {
    SystemMessage add(HomeDtoInput homeDtoInput);

    SystemMessage edit(HomeDtoInput homeDtoInput);

    Home findById(Long id);

    List<Home> findAll();

    void deleteById(Long id);
}
