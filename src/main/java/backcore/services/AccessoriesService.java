package backcore.services;

import backcore.entities.AccessoryEntity;
import backcore.repositories.AccessoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccessoriesService {

    @Autowired
    AccessoriesRepository accessoriesRepository;

    public List<AccessoryEntity> getAccesories(Map<String, Object> params) {
        List<AccessoryEntity> accessories;
        if (params.get("ids") != null) {
            accessories = accessoriesRepository.findAllById((List<Long>) params.get("ids"));
        } else if (params.get("type") != null) {
            accessories = accessoriesRepository.findAllByType((String) params.get("type"));
        } else if (params.get("name") != null) {
            accessories = accessoriesRepository.findAllByName((String) params.get("name"));
        } else {
            accessories = accessoriesRepository.findAll();
        }
        return accessories;
    }

    public List<String> getAccessoriesTypes() {
        return accessoriesRepository.getAccessoriesTypes();
    }

    public List<String> getAccessoriesManufacturers(String type) {
        return accessoriesRepository.getAccessoriesManufacturers(type);
    }

}
