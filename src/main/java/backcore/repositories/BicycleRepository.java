package backcore.repositories;

import backcore.entities.BicycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicycleRepository extends JpaRepository<BicycleEntity, Long> {
    List<BicycleEntity> findAllByBicycleType(String type);
    List<BicycleEntity> findAllByBicycleName(String name);

}
