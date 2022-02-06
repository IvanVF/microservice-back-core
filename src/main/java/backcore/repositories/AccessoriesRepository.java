package backcore.repositories;

import backcore.entities.AccessoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccessoriesRepository extends JpaRepository<AccessoryEntity, Long> {
    List<AccessoryEntity> findAllByType(String type);
    List<AccessoryEntity> findAllByName(String name);

    /**
     * Load available accessories types
     * @return
     */
    @Query("SELECT DISTINCT acessory.type FROM AccessoryEntity acessory")
    List<String> getAccessoriesTypes();

    /**
     * Load available accessories manufacturers for chosen type
     */
    @Query("SELECT DISTINCT accessories.manufacturer FROM AccessoryEntity accessories where accessories.type = ?1")
    List<String> getAccessoriesManufacturers(String type);
}
