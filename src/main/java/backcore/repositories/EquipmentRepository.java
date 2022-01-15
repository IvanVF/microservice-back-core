package backcore.repositories;

import backcore.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
    List<EquipmentEntity> findAllByType(String type);
    List<EquipmentEntity> findAllByName(String name);
}
