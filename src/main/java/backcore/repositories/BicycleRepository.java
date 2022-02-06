package backcore.repositories;

import backcore.entities.BicycleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleRepository extends JpaRepository<BicycleEntity, Long> {
    List<BicycleEntity> findAllByType(String type);
    List<BicycleEntity> findAllByName(String name);

    /**
     * Load available bicycle types
     * @return
     */
    @Query("SELECT DISTINCT bicycles.type FROM BicycleEntity bicycles")
    List<String> getBicycleTypes();


    /**
     * Load available bicycles manufacturers for chosen type
     */
    @Query("SELECT DISTINCT bicycles.manufacturer FROM BicycleEntity bicycles where bicycles.type = ?1")
    List<String> getBicycleManufacturers(String type);

}
