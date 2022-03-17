package line2.line2_back.homeImageTable.controller;

import line2.line2_back.homeImageTable.model.HomeImageTable;

import java.util.List;

public interface HomeImageTableController {
    HomeImageTable add(HomeImageTable homeImageTable);

    HomeImageTable edit(HomeImageTable homeImageTable);

    void deleteById(Long id);

    List<HomeImageTable> findByHomeId(Long id);
}
