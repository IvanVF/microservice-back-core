package backcore.controllers;

import backcore.entities.AccessoryEntity;
import backcore.services.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccessoriesController {

    @Autowired
    AccessoriesService accessoriesService;

    @GetMapping(path = "/accessories")
    public List<AccessoryEntity> getAccessories(@RequestParam(name = "ids", required = false) List<Long> ids,
                                                @RequestParam(name = "name", required = false) String name,
                                                @RequestParam(name = "type", required = false) String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("type", type);
        return accessoriesService.getAccesories(params);
    }
}