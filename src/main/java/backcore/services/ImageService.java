package backcore.services;

import backcore.entitys.ImageEntity;
import backcore.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public String putImage(ImageEntity img) {
        try {
            imageRepository.save(img);
            return "Success";
        } catch (Exception e) {
            return "Cant put image" + e.getMessage();
        }
    }

    public ImageEntity getPhoto(Long id) {
        return imageRepository.getById(id);
    }
}
