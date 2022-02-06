package backcore.controllers;

import backcore.entities.AccessoryEntity;
import backcore.services.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accessories")
public class AccessoriesController {

    @Autowired
    AccessoriesService accessoriesService;

    @GetMapping
    public List<AccessoryEntity> getAccessories(@RequestParam(name = "ids", required = false) List<Long> ids,
                                                @RequestParam(name = "name", required = false) String name,
                                                @RequestParam(name = "type", required = false) String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("type", type);
        return accessoriesService.getAccesories(params);
    }

    /**
     * Load accessories types
     */
    @GetMapping(path = "/types")
    public List<String> getAccessoriesTypes() {
        return accessoriesService.getAccessoriesTypes();
    }

    /**
     * Load accessories manufacturers for chosen type
     */
    @GetMapping(path = "/manufacturers")
    public List<String> getAccessoriesManufacturers(@RequestParam(name = "type") String type) {
        return accessoriesService.getAccessoriesManufacturers(type);
    }
}
