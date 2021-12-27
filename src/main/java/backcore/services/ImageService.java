package backcore.services;

import backcore.entities.ImageEntity;
import backcore.repositories.ImageRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {
    private static SessionFactory sessionFactory;

    @Autowired
    ImageRepository imageRepository;

    public String postImage(ImageEntity img) {
        try {
            imageRepository.save(img);
            return "Success";
        } catch (Exception e) {
            return "Cant put image" + e.getMessage();
        }
    }

    public List<ImageEntity> getImages(Map<String, Object> params) {
        List<ImageEntity> images = new ArrayList<>();

        if (params.get("ids") != null) {
            images = imageRepository.findAllById((List<Long>) params.get("ids"));
        } else if (params.get("type") != null) {
            images = imageRepository.findAllByType((String) params.get("type"));
        } else if (params.get("name") != null) {
            images = imageRepository.findAllByName((String) params.get("name"));
        }
        return images;
    }
}
