package backcore.services;

import backcore.entities.ScooterEntity;
import backcore.repositories.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Service
public class ScooterService {

    @Autowired
    ScooterRepository scooterRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ScooterEntity> getScooters(Map<String, Object> params, List<Long> ids) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ScooterEntity> query = criteriaBuilder.createQuery(ScooterEntity.class);
        Root<ScooterEntity> scooter = query.from(ScooterEntity.class);

        Predicate criteria = criteriaBuilder.conjunction();

        if (ids != null) {
            for (Long id: ids) {
                Predicate p = criteriaBuilder.equal(scooter.get("id"), id);
                criteria = criteriaBuilder.and(criteria, p);
            }
        }

        if (params.get("name") != null && params.get("name") !="") {
            Predicate p = criteriaBuilder.equal(scooter.get("name"), params.get("name"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("priceFrom") != null && (Double) params.get("priceFrom") > 0) {
            Predicate p = criteriaBuilder.greaterThanOrEqualTo(scooter.get("price"), (Double) params.get("priceFrom"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("priceTo") != null && (Double) params.get("priceTo") > 0) {
            Predicate p = criteriaBuilder.lessThanOrEqualTo(scooter.get("price"), (Double) params.get("priceTo"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("manufacturer") != null && params.get("manufacturer") != "") {
            Predicate p = criteriaBuilder.equal(scooter.get("manufacturer"), params.get("manufacturer"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("type") != null && params.get("type") != "") {
            Predicate p = criteriaBuilder.equal(scooter.get("type"), params.get("type"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if ((Boolean) params.get("isInStock")) {
            Predicate p = criteriaBuilder.equal(scooter.get("availability"), true);
            criteria = criteriaBuilder.and(criteria, p);
        }

        if ((Boolean) params.get("isHaveDiscount")) {
            Predicate p = criteriaBuilder.greaterThan(scooter.get("discount"), 0);
            criteria = criteriaBuilder.and(criteria, p);
        }
        query.where(criteria);

        return entityManager.createQuery(query).getResultList();
    }

    public List<String> getScootersTypes() {
        return scooterRepository.getScootersTypes();
    }

    public List<String> getScootersManufacturers(String type) {
        return scooterRepository.getScootersManufacturers(type);
    }
}
