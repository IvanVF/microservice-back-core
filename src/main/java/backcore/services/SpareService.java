package backcore.services;

import backcore.entities.SpareEntity;
import backcore.repositories.SpareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Service
public class SpareService {

    @Autowired
    SpareRepository spareRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<SpareEntity> getSpares (Map<String, Object> params, List<Long> ids) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SpareEntity> query = criteriaBuilder.createQuery(SpareEntity.class);
        Root<SpareEntity> spare = query.from(SpareEntity.class);

        Predicate criteria = criteriaBuilder.conjunction();

        if (ids != null) {
            for (Long id: ids) {
                Predicate p = criteriaBuilder.equal(spare.get("id"), id);
                criteria = criteriaBuilder.and(criteria, p);
            }
        }

        if (params.get("name") != null && params.get("name") !="") {
            Predicate p = criteriaBuilder.equal(spare.get("name"), params.get("name"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("priceFrom") != null && (Double) params.get("priceFrom") > 0) {
            Predicate p = criteriaBuilder.greaterThanOrEqualTo(spare.get("price"), (Double) params.get("priceFrom"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("priceTo") != null && (Double) params.get("priceTo") > 0) {
            Predicate p = criteriaBuilder.lessThanOrEqualTo(spare.get("price"), (Double) params.get("priceTo"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("manufacturer") != null && params.get("manufacturer") != "") {
            Predicate p = criteriaBuilder.equal(spare.get("manufacturer"), params.get("manufacturer"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("type") != null && params.get("type") != "") {
            Predicate p = criteriaBuilder.equal(spare.get("type"), params.get("type"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if ((Boolean) params.get("isInStock")) {
            Predicate p = criteriaBuilder.equal(spare.get("availability"), true);
            criteria = criteriaBuilder.and(criteria, p);
        }

        if ((Boolean) params.get("isHaveDiscount")) {
            Predicate p = criteriaBuilder.greaterThan(spare.get("discount"), 0);
            criteria = criteriaBuilder.and(criteria, p);
        }
        query.where(criteria);

        return entityManager.createQuery(query).getResultList();
    }

    public List<String> getSparesTypes() {
        return spareRepository.getSparesTypes();
    }

    public List<String> getSparesManufacturers(String type) {
        return spareRepository.getSparesManufacturers(type);
    }
}
