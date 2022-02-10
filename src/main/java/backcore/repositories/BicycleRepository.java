package backcore.repositories;

import backcore.entities.BicycleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleRepository extends JpaRepository<BicycleEntity, Long> {

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

    @Query(nativeQuery=true, value="SELECT * FROM bicycles\n" +
            "where bicycles.name ILIKE ?1||'%'\n" +
            "OR (bicycles.name ILIKE substring(?1||'%' from '^(.*?) ')||'%'\n " +
            "and concat_ws(' ',bicycles.name) ILIKE ?1||'%') " +
            "ORDER BY bicycles.name")
    List<BicycleEntity> getBicyclesBySearchString(String searchString);

}
