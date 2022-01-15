package backcore.services;

import backcore.entities.EquipmentEntity;
import backcore.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public List<EquipmentEntity> getEquipments (Map<String, Object> params) {
        List<EquipmentEntity> equimpments;
        if (params.get("ids") != null) {
            equimpments = equipmentRepository.findAllById((List<Long>) params.get("ids"));
        } else if (params.get("type") != null) {
            equimpments = equipmentRepository.findAllByType((String) params.get("type"));
        } else if (params.get("name") != null) {
            equimpments = equipmentRepository.findAllByName((String) params.get("name"));
        } else {
            equimpments = equipmentRepository.findAll();
        }
        return equimpments;
    }
}
