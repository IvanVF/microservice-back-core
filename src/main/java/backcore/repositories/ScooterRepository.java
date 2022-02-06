package backcore.repositories;

import backcore.entities.ScooterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScooterRepository extends JpaRepository<ScooterEntity, Long> {
    List<ScooterEntity> findAllByType(String type);
    List<ScooterEntity> findAllByName(String name);

    /**
     * Load available scooters types
     * @return
     */
    @Query("SELECT DISTINCT scooters.type FROM ScooterEntity scooters")
    List<String> getScootersTypes();

    /**
     * Load available scooters manufacturers for chosen type
     */
    @Query("SELECT DISTINCT scooters.manufacturer FROM ScooterEntity scooters where scooters.type = ?1")
    List<String> getScootersManufacturers(String type);
}
