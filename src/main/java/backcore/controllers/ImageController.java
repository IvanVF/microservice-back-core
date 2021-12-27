package backcore.controllers;

import backcore.entities.ImageEntity;
import backcore.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping(path = "images")
    public String postImage(@RequestBody ImageEntity imageEntity) {
        imageService.postImage(imageEntity);
        return "success";
    }

    @GetMapping(path = "/images")
    public List<ImageEntity> getImage(@RequestParam(name = "ids", required = false) List<Long> ids,
                                      @RequestParam(name = "name", required = false) String name,
                                      @RequestParam(name = "type", required = false) String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("name", name);
        params.put("type", type);
        return imageService.getImages(params);
    }

}


