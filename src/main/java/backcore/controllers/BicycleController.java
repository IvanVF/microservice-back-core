package backcore.controllers;

import backcore.entities.BicycleEntity;
import backcore.services.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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
     */
    @GetMapping
    public List<BicycleEntity> getBicycles(@RequestParam(name = "ids", required = false) List<Long> ids,
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

        return bicycleService.getBicycles(params, ids);
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


