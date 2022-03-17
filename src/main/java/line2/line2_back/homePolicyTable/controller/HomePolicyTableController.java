package line2.line2_back.homePolicyTable.controller;

import line2.line2_back.homePolicyTable.model.HomePolicyTable;

import java.util.List;

public interface HomePolicyTableController {
    HomePolicyTable add(HomePolicyTable homePolicyTable);

    HomePolicyTable edit(HomePolicyTable homePolicyTable);

    void deleteById(Long id);

    List<HomePolicyTable> findByHomeId(Long id);
}
