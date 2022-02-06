package backcore.services;

import backcore.entities.SpareEntity;
import backcore.repositories.SpareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SpareService {

    @Autowired
    SpareRepository spareRepository;

    public List<SpareEntity> getSpares (Map<String, Object> params) {
        List<SpareEntity> spares;
        if (params.get("ids") != null) {
            spares = spareRepository.findAllById((List<Long>) params.get("ids"));
        } else if (params.get("type") != null) {
            spares = spareRepository.findAllByType((String) params.get("type"));
        } else if (params.get("name") != null) {
            spares = spareRepository.findAllByName((String) params.get("name"));
        } else {
            spares = spareRepository.findAll();
        }
        return spares;
    }

    public List<String> getSparesTypes() {
        return spareRepository.getSparesTypes();
    }

    public List<String> getSparesManufacturers(String type) {
        return spareRepository.getSparesManufacturers(type);
    }
}
