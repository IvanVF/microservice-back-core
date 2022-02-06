package backcore.controllers;

import backcore.entities.BicycleEntity;
import backcore.services.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/bicycles")
public class BicycleController {

    @Autowired
    BicycleService bicycleService;

    @PostMapping
    public String postBicycle(@RequestBody BicycleEntity bicycleEntity) {
        bicycleService.postBicycles(bicycleEntity);
        return "success";
    }

    /**
     * Load bicycles with filters
     * @param ids
     * @param name
     * @param type
     * @return
     */
    @GetMapping
    public List<BicycleEntity> getBicycles(@RequestParam(name = "ids", required = false) List<Long> ids,
                                            @RequestParam(name = "name", required = false) String name,
                                            @RequestParam(name = "type", required = false) String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("type", type);
        return bicycleService.getBicycles(params);
    }

    /**
     * Load bicycles types
     */
    @GetMapping(path = "/types")
    public List<String> getBicycleTypes() {
        return bicycleService.getBicycleTypes();
    }

    /**
     * Load available bicycles manufacturers for chosen type
     */
    @GetMapping(path = "/manufacturers")
    public List<String> getBicycleManufacturers(@RequestParam(name = "type") String type) {
        return bicycleService.getBicycleManufacturers(type);
    }

}


