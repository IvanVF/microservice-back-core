package backcore.services;

import backcore.entities.BicycleEntity;
import backcore.repositories.BicycleRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BicycleService {
    private static SessionFactory sessionFactory;

    @Autowired
    BicycleRepository bicycleRepository;

    public String postBicycles(BicycleEntity img) {
        try {
            bicycleRepository.save(img);
            return "Success";
        } catch (Exception e) {
            return "Cant put image" + e.getMessage();
        }
    }

    public List<BicycleEntity> getBicycles(Map<String, Object> params) {
        List<BicycleEntity> bicycles = new ArrayList<>();

        if (params.get("ids") != null) {
            bicycles = bicycleRepository.findAllById((List<Long>) params.get("ids"));
        } else if (params.get("type") != null) {
            bicycles = bicycleRepository.findAllByBicycleType((String) params.get("type"));
        } else if (params.get("name") != null) {
            bicycles = bicycleRepository.findAllByBicycleName((String) params.get("name"));
        }
        return bicycles;
    }
}