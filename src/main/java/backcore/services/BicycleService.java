package backcore.services;

import backcore.entities.BicycleEntity;
import backcore.repositories.BicycleRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import java.util.*;

@Service
public class BicycleService {

    @Autowired
    BicycleRepository bicycleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public String postBicycles(BicycleEntity img) {
        try {
            bicycleRepository.save(img);
            return "Success";
        } catch (Exception e) {
            return "Cant put image" + e.getMessage();
        }
    }

    public List<String> getBicycleTypes() {
        return bicycleRepository.getBicycleTypes();
    }

    public List<String> getBicycleManufacturers(String type) {
        return bicycleRepository.getBicycleManufacturers(type);
    }

    /**
     * Get bicycles by filters
     */
    public List<BicycleEntity> getBicycles(Map<String, Object> params, List<Long> ids) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BicycleEntity> query = criteriaBuilder.createQuery(BicycleEntity.class);
        Root<BicycleEntity> bicycle = query.from(BicycleEntity.class);

        Predicate criteria = criteriaBuilder.conjunction();

        if (ids != null) {
            for (Long id: ids) {
                Predicate p = criteriaBuilder.equal(bicycle.get("id"), id);
                criteria = criteriaBuilder.and(criteria, p);
            }
        }

        if (params.get("name") != null && params.get("name") !="") {
            Predicate p = criteriaBuilder.equal(bicycle.get("name"), params.get("name"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("priceFrom") != null && (Double) params.get("priceFrom") > 0) {
            Predicate p = criteriaBuilder.greaterThanOrEqualTo(bicycle.get("price"), (Double) params.get("priceFrom"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("priceTo") != null && (Double) params.get("priceTo") > 0) {
            Predicate p = criteriaBuilder.lessThanOrEqualTo(bicycle.get("price"), (Double) params.get("priceTo"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("manufacturer") != null && params.get("manufacturer") != "") {
            Predicate p = criteriaBuilder.equal(bicycle.get("manufacturer"), params.get("manufacturer"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("type") != null && params.get("type") != "") {
            Predicate p = criteriaBuilder.equal(bicycle.get("type"), params.get("type"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if ((Boolean) params.get("isInStock")) {
            Predicate p = criteriaBuilder.equal(bicycle.get("availability"), true);
            criteria = criteriaBuilder.and(criteria, p);
        }

        if ((Boolean) params.get("isHaveDiscount")) {
            Predicate p = criteriaBuilder.greaterThan(bicycle.get("discount"), 0);
            criteria = criteriaBuilder.and(criteria, p);
        }
        query.where(criteria);

        return entityManager.createQuery(query).getResultList();
    }

    public List<BicycleEntity> getBicyclesBySearchString(String searchString) {
        return bicycleRepository.getBicyclesBySearchString(searchString);
    }
}
