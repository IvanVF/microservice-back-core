package backcore.jpa_repositories;

import backcore.entities.ProductTypeDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeDescriptionJpaRepository extends JpaRepository<ProductTypeDescriptionEntity, Long> {
    ProductTypeDescriptionEntity getByName(String name);
}
