package line2.line2_back.homeFacilityTable.controller;

import line2.line2_back.homeFacilityTable.model.HomeFacilityTable;
import line2.line2_back.homeFacilityTable.service.HomeFacilityTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class HomeFacilityTableControllerImpl implements HomeFacilityTableController{
    private final HomeFacilityTableService homeFacilityTableService;

    @Override
    @PostMapping("/v1/home_facility_table/add")
    public HomeFacilityTable add(@RequestBody HomeFacilityTable homeFacilityTable) {
        try {
            log.info("HomeFacilityTableController add HomeFacilityTable({}) start", homeFacilityTable);
            return homeFacilityTableService.save(homeFacilityTable);
        } catch (Exception e) {
            log.error("HomeFacilityTableController add HomeFacilityTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityTableController add HomeFacilityTable end");
        }
    }

    @Override
    @PutMapping("/v1/home_facility_table/edit")
    public HomeFacilityTable edit(@RequestBody HomeFacilityTable homeFacilityTable) {
        try {
            log.info("HomeFacilityTableController edit HomeFacilityTable({}) start", homeFacilityTable);
            return homeFacilityTableService.save(homeFacilityTable);
        } catch (Exception e) {
            log.error("HomeFacilityTableController edit HomeFacilityTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityTableController edit HomeFacilityTable end");
        }
    }

    @Override
    @DeleteMapping("/v1/home_facility_table/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            log.info("HomeFacilityTableController delete by id HomeFacilityTable(id: {}) start", id);
            homeFacilityTableService.deleteById(id);
        } catch (Exception e) {
            log.error("HomeFacilityTableController delete by id HomeFacilityTable failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeFacilityTableController delete by id HomeFacilityTable end");
        }
    }

    @Override
    @GetMapping("/v1/home_facility_table/get_home_id/{id}")
    public List<HomeFacilityTable> findByHomeId(@PathVariable Long id) {
        try {
            log.info("HomeFacilityTableController find by home id HomeFacilityTable(id: {}) start", id);
            return homeFacilityTableService.findByHomeId(id);
        } catch (Exception e) {
            log.error("HomeFacilityTableController find by home id HomeFacilityTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityTableController find by home id HomeFacilityTable end");
        }
    }
}