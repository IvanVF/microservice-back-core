package backcore.services;

import backcore.entities.ProductTypeDescriptionEntity;
import backcore.repositories.ProductTypeDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeDescriptionService {

    @Autowired
    ProductTypeDescriptionRepository descriptionRepository;

    public ProductTypeDescriptionEntity getDescriptionByName(String name) {
        return descriptionRepository.getByName(name);
    }
}
