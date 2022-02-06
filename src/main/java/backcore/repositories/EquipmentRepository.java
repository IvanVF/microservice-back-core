package backcore.repositories;

import backcore.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
    List<EquipmentEntity> findAllByType(String type);
    List<EquipmentEntity> findAllByName(String name);

    /**
     * Load available equipment types
     * @return
     */
    @Query("SELECT DISTINCT equipment.type FROM EquipmentEntity equipment")
    List<String> getEquipmentTypes();

    /**
     * Load available equipments manufacturers for chosen type
     */
    @Query("SELECT DISTINCT equipment.manufacturer FROM EquipmentEntity equipment where equipment.type = ?1")
    List<String> getEquipmentManufacturers(String type);
}
