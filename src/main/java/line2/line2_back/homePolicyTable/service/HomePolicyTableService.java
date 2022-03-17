package line2.line2_back.homePolicyTable.service;

import line2.line2_back.homePolicyTable.model.HomePolicyTable;

import java.util.List;

public interface HomePolicyTableService {
    HomePolicyTable save(HomePolicyTable homePolicyTable);

    void deleteById(Long id);

    List<HomePolicyTable> findByHomeId(Long id);
}
