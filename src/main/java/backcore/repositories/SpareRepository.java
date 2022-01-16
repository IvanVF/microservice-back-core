package backcore.repositories;

import backcore.entities.SpareEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpareRepository extends JpaRepository<SpareEntity, Long> {
    List<SpareEntity> findAllByType(String type);
    List<SpareEntity> findAllByName(String name);
}
