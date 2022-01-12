package backcore.services;

import backcore.entities.ScooterEntity;
import backcore.repositories.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScooterService {

    @Autowired
    ScooterRepository scooterRepository;

    public List<ScooterEntity> getScooters(Map<String, Object> params) {
        List<ScooterEntity> scooters;
        if (params.get("ids") != null) {
            scooters = scooterRepository.findAllById((List<Long>) params.get("ids"));
        } else if (params.get("type") != null) {
            scooters = scooterRepository.findAllByType((String) params.get("type"));
        } else if (params.get("name") != null) {
            scooters = scooterRepository.findAllByName((String) params.get("name"));
        } else {
            scooters = scooterRepository.findAll();
        }
        return scooters;
    }
}
