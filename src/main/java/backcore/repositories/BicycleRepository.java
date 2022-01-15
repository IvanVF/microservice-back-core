package backcore.repositories;

import backcore.entities.BicycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicycleRepository extends JpaRepository<BicycleEntity, Long> {
    List<BicycleEntity> findAllByType(String type);
    List<BicycleEntity> findAllByName(String name);

}
