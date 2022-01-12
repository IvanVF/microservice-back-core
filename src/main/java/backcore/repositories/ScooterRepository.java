package backcore.repositories;

import backcore.entities.ScooterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScooterRepository extends JpaRepository<ScooterEntity, Long> {
    List<ScooterEntity> findAllByType(String type);
    List<ScooterEntity> findAllByName(String name);
}
