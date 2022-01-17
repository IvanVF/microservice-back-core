package backcore.repositories;

import backcore.entities.ProductTypeDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeDescriptionRepository extends JpaRepository<ProductTypeDescriptionEntity, Long> {
    ProductTypeDescriptionEntity getByName(String name);
}
