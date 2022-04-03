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
                                            @RequestParam(name = "priceFrom", required = false) String priceFromString,
                                            @RequestParam(name = "priceTo", required = false) String priceToString,
                                            @RequestParam(name = "isInStock", required = false, defaultValue = "false") Boolean isInStock,
                                            @RequestParam(name = "isHaveDiscount", required = false, defaultValue = "false") Boolean isHaveDiscount,
                                            @RequestParam(name = "type", required = false) String type,
                                            @RequestParam(name = "manufacturer", required = false) String manufacturer,
                                            @RequestParam(name = "page", required = false, defaultValue = "1") String pageString,
                                            @RequestParam(name = "perPage", required = false, defaultValue = "15") String perPageString) {

        Double priceFrom = 0.0;
        Double priceTo = 0.0;
        Integer page = 1;
        Integer perPage = 15;
        try {
            page = Integer.valueOf(pageString);
            perPage = Integer.valueOf(perPageString);
        } catch (ClassCastException e) {
            System.out.println("Can't cast page or perPage. " + e.getMessage());
        }

        if (priceFromString != null && !priceFromString.equals("null")) {
            try {
                priceFrom = Double.parseDouble(priceFromString);
            } catch (ClassCastException e) {
                System.out.println("Wrong priceFrom" + e.getMessage());
            }
        }
        if (priceToString != null && !priceToString.equals("null")) {
            try {
                priceTo = Double.parseDouble(priceToString);
            } catch (ClassCastException e) {
                System.out.println("Wrong price to. " + e.getMessage());
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("priceFrom", priceFrom);
        params.put("priceTo", priceTo);
        params.put("isInStock", isInStock);
        params.put("isHaveDiscount", isHaveDiscount);
        params.put("type", type);
        params.put("manufacturer", manufacturer);
        params.put("page", page);
        params.put("perPage", perPage);

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

    @GetMapping(path = "/search_string")
    public List<BicycleEntity> getBicyclesBySearchString(@RequestParam(name = "searchString") String searchString) {
        return bicycleService.getBicyclesBySearchString(searchString);
    }

}


