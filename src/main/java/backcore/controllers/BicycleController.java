package backcore.controllers;

import backcore.entities.BicycleEntity;
import backcore.services.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class BicycleController {

    @Autowired
    BicycleService bicycleService;

    @PostMapping(path = "bicycles")
    public String postBicycle(@RequestBody BicycleEntity bicycleEntity) {
        bicycleService.postBicycles(bicycleEntity);
        return "success";
    }

    @GetMapping(path = "/bicycles")
    public List<BicycleEntity> getImage(@RequestParam(name = "ids", required = false) List<Long> ids,
                                        @RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "type", required = false) String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("type", type);
        return bicycleService.getBicycles(params);
    }

}


