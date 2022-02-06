package backcore.repositories;

import backcore.entities.SpareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpareRepository extends JpaRepository<SpareEntity, Long> {
    List<SpareEntity> findAllByType(String type);
    List<SpareEntity> findAllByName(String name);

    /**
     * Load available spares types
     * @return
     */
    @Query("SELECT DISTINCT spares.type FROM SpareEntity spares")
    List<String> getSparesTypes();

    /**
     * Load available spares manufacturers for chosen type
     */
    @Query("SELECT DISTINCT spares.manufacturer FROM SpareEntity spares where spares.type = ?1")
    List<String> getSparesManufacturers(String type);
}
