package backcore.redis_repositories;

import backcore.entities.BicycleEntity;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository("bicycleRedisRepository")
public interface BicycleRedisRepository extends RevisionRepository<BicycleEntity, Long, Integer> {
}
