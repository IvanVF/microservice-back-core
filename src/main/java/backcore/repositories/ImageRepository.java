package backcore.repositories;

import backcore.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    List<ImageEntity> findAllByType(String type);
    List<ImageEntity> findAllByName(String name);

}
