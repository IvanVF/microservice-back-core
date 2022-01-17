package backcore.controllers;

import backcore.entities.ProductTypeDescriptionEntity;
import backcore.services.ProductTypeDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductTypeDescriptionController {

    @Autowired
    ProductTypeDescriptionService descriptionService;

    @GetMapping(path = "/product_type_description")
    public ProductTypeDescriptionEntity getDescription(@RequestParam(name = "name") String name) {
        return descriptionService.getDescriptionByName(name);
    }
}
