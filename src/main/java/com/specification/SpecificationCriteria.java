package com.specification;

import com.entity.DriverEntity;
import com.enumeration.DriverStatus;
import org.springframework.beans.factory.annotation.Autowired;
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

        if(request.getStatus()!=null){
            predicates.add(cb.equal(root.get("status"), request.getStatus()));
        }
        if(request.getCoordinate()!=null){
            predicates.add(cb.equal(root.get("coordinate"), request.getCoordinate()));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }


} //END CLASS
