package backcore.controllers;

import backcore.entities.ScooterEntity;
import backcore.services.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scooters")
public class ScooterController {

    @Autowired
    ScooterService scooterService;

    /**
     * Load scooters with filters
     */
    @GetMapping
    public List<ScooterEntity> getScooters(@RequestParam(name = "ids", required = false) List<Long> ids,
                                           @RequestParam(name = "name", required = false) String name,
                                           @RequestParam(name = "priceFrom", required = false) String priceFrom,
                                           @RequestParam(name = "priceTo", required = false) String priceTo,
                                           @RequestParam(name = "isInStock", required = false, defaultValue = "false") Boolean isInStock,
                                           @RequestParam(name = "isHaveDiscount", required = false, defaultValue = "false") Boolean isHaveDiscount,
                                           @RequestParam(name = "type", required = false) String type,
                                           @RequestParam(name = "manufacturer", required = false) String manufacturer) {

        Double priceFromConverted = 0.0;
        Double priceToConverted = 0.0;
        if (priceFrom != null && !priceFrom.equals("null")) {
            try {
                priceFromConverted = Double.parseDouble(priceFrom);
            } catch (ClassCastException e) {
                System.out.println("Wrong priceFrom" + e.getMessage());
            }
        }
        if (priceTo != null && !priceTo.equals("null")) {
            try {
                priceToConverted = Double.parseDouble(priceTo);
            } catch (ClassCastException e) {
                System.out.println("Wrong price to. " + e.getMessage());
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("priceFrom", priceFromConverted);
        params.put("priceTo", priceToConverted);
        params.put("isInStock", isInStock);
        params.put("isHaveDiscount", isHaveDiscount);
        params.put("type", type);
        params.put("manufacturer", manufacturer);

        return scooterService.getScooters(params, ids);
    }

    /**
     * Load scooter types
     */
    @GetMapping(path = "/types")
    public List<String> getScooterTypes() {
        return scooterService.getScootersTypes();
    }

    /**
     * Load scooter manufacturers for chosen type
     */
    @GetMapping(path = "/manufacturers")
    public List<String> getScooterManufacturers(@RequestParam(name = "type") String type) {
        return scooterService.getScootersManufacturers(type);
    }
}
