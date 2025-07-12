package com.specification;

import com.entity.DriverEntity;
import com.enumeration.DriverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpecificationCriteria {

    @Autowired
    private EntityManager em;

    public List<DriverEntity> findAllBySimpleQuery(SearchRequest request){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DriverEntity> cq = cb.createQuery(DriverEntity.class);
        Root<DriverEntity> root = cq.from(DriverEntity.class);
        cq.select(root);
        List<Predicate> predicates = new ArrayList<>();

        if(request.getStatus()!=null) {
            predicates.add(cb.equal(root.get("status"), DriverStatus.valueOf(request.getStatus())));
        }
        if (request.getLatitude() != null || request.getLongitude() != null) {
            if ((request.getLatitude() != null) ^ (request.getLongitude() != null)) {
                throw new RuntimeException("Both latitude and longitude must be provided together.");
            }
            // if longitude and latitude not null, so add predicates
            predicates.add(cb.equal(root.get("latitude"), request.getLatitude()));
            predicates.add(cb.equal(root.get("longitude"), request.getLongitude()));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }


} //END CLASS
