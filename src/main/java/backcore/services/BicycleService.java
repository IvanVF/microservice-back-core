package backcore.services;

import backcore.entities.BicycleEntity;
import backcore.repositories.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BicycleService {

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
        List<BicycleEntity> bicycles;

        if (params.get("ids") != null) {
            bicycles = bicycleRepository.findAllById((List<Long>) params.get("ids"));
        } else if (params.get("type") != null) {
            bicycles = bicycleRepository.findAllByType((String) params.get("type"));
        } else if (params.get("name") != null) {
            bicycles = bicycleRepository.findAllByName((String) params.get("name"));
        } else {
            bicycles = bicycleRepository.findAll();
        }
        return bicycles;
    }

    public List<String> getBicycleTypes() {
        return bicycleRepository.getBicycleTypes();
    }

    public List<String> getBicycleManufacturers(String type) {
        return bicycleRepository.getBicycleManufacturers(type);
    }
}
