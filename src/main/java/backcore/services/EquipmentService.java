package backcore.services;

import backcore.entities.EquipmentEntity;
import backcore.repositories.EquipmentRepository;
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
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<EquipmentEntity> getEquipments (Map<String, Object> params, List<Long> ids) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EquipmentEntity> query = criteriaBuilder.createQuery(EquipmentEntity.class);
        Root<EquipmentEntity> equipment = query.from(EquipmentEntity.class);

        Predicate criteria = criteriaBuilder.conjunction();

        if (ids != null) {
            for (Long id: ids) {
                Predicate p = criteriaBuilder.equal(equipment.get("id"), id);
                criteria = criteriaBuilder.and(criteria, p);
            }
        }

        if (params.get("name") != null && params.get("name") !="") {
            Predicate p = criteriaBuilder.equal(equipment.get("name"), params.get("name"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("priceFrom") != null && (Double) params.get("priceFrom") > 0) {
            Predicate p = criteriaBuilder.greaterThanOrEqualTo(equipment.get("price"), (Double) params.get("priceFrom"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("priceTo") != null && (Double) params.get("priceTo") > 0) {
            Predicate p = criteriaBuilder.lessThanOrEqualTo(equipment.get("price"), (Double) params.get("priceTo"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("manufacturer") != null && params.get("manufacturer") != "") {
            Predicate p = criteriaBuilder.equal(equipment.get("manufacturer"), params.get("manufacturer"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if (params.get("type") != null && params.get("type") != "") {
            Predicate p = criteriaBuilder.equal(equipment.get("type"), params.get("type"));
            criteria = criteriaBuilder.and(criteria, p);
        }

        if ((Boolean) params.get("isInStock")) {
            Predicate p = criteriaBuilder.equal(equipment.get("availability"), true);
            criteria = criteriaBuilder.and(criteria, p);
        }

        if ((Boolean) params.get("isHaveDiscount")) {
            Predicate p = criteriaBuilder.greaterThan(equipment.get("discount"), 0);
            criteria = criteriaBuilder.and(criteria, p);
        }
        query.where(criteria);

        return entityManager.createQuery(query).getResultList();
    }

    public List<String> getEquipmentsTypes() {
        return equipmentRepository.getEquipmentTypes();
    }

    public List<String> getEquipmentsManufacturers(String type) {
        return equipmentRepository.getEquipmentManufacturers(type);
    }
}
