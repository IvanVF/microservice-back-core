package backcore.services;

import backcore.entities.ProductTypeDescriptionEntity;
import backcore.jpa_repositories.ProductTypeDescriptionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeDescriptionService {

    @Autowired
    ProductTypeDescriptionJpaRepository descriptionRepository;

    public ProductTypeDescriptionEntity getDescriptionByName(String name) {
        return descriptionRepository.getByName(name);
    }
}
