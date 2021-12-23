package backcore.controllers;

import backcore.entitys.ImageEntity;
import backcore.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping(path = "image")
    public String postImage(@RequestBody ImageEntity imageEntity) {
        int b = 2;
        return "success";
    }

    /*
    @PostMapping(path = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String postPhoto(@RequestParam("description") String description,
                              @RequestParam("type") String type,
                              @RequestParam("imageFile")MultipartFile imageFile) {
        try (InputStream is = imageFile.getInputStream()) {

            ImageEntity img = new ImageEntity();
            img.setImageBlob(imageFile.getBytes());
            img.setDescription(description);
            img.setType(type);

            return imageService.putImage(img);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    @GetMapping(path = "/image")
    public ImageEntity getPhoto(@RequestParam("id") Long id) {
        return imageService.getPhoto(id);
    }

}


