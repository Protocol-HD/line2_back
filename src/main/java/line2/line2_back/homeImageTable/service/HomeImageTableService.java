package line2.line2_back.homeImageTable.service;

import line2.line2_back.homeImageTable.model.HomeImageTable;

import java.util.List;

public interface HomeImageTableService {
    HomeImageTable save(HomeImageTable homeImageTable);

    void deleteById(Long id);

    List<HomeImageTable> findByHomeId(Long id);
}
