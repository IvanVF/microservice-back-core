package backcore.controllers;

import backcore.entities.EquipmentEntity;
import backcore.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @GetMapping
    public List<EquipmentEntity> getEquipments(@RequestParam(name = "ids", required = false) List<Long> ids,
                                               @RequestParam(name = "name", required = false) String name,
                                               @RequestParam(name = "type", required = false) String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("type", type);
        return equipmentService.getEquipments(params);
    }

    /**
     * Load equipment types
     */
    @GetMapping(path = "/types")
    public List<String> getEquipmentTypes() {
        return equipmentService.getEquipmentsTypes();
    }

    /**
     * Load equipments manufacturers for chosen type
     */
    @GetMapping(path = "/manufacturers")
    public List<String> getEquipmentsManufacturers(@RequestParam(name = "type") String type) {
        return equipmentService.getEquipmentsManufacturers(type);
    }
}
