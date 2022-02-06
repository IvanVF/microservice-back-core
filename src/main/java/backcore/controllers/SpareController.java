package backcore.controllers;

import backcore.entities.SpareEntity;
import backcore.services.SpareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/spare")
public class SpareController {

    @Autowired
    SpareService spareService;

    @GetMapping
    public List<SpareEntity> getEquipments(@RequestParam(name = "ids", required = false) List<Long> ids,
                                           @RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "type", required = false) String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("type", type);
        return spareService.getSpares(params);
    }

    /**
     * Load spare types
     */
    @GetMapping(path = "/types")
    public List<String> getSpareTypes() {
        return spareService.getSparesTypes();
    }

    /**
     * Load spares manufacturers for chosen type
     */
    @GetMapping(path = "/manufacturers")
    public List<String> getSparesManufacturers(@RequestParam(name = "type") String type) {
        return spareService.getSparesManufacturers(type);
    }
}
