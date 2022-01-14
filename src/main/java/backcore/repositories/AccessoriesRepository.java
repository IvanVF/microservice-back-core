package backcore.repositories;

import backcore.entities.AccessoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessoriesRepository extends JpaRepository<AccessoryEntity, Long> {
    List<AccessoryEntity> findAllByType(String type);
    List<AccessoryEntity> findAllByName(String name);
}
