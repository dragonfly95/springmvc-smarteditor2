package com.system.blog.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
public class FamerController {

//    private static EntityManagerFactory emf;
    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping("famer")
    private ResponseEntity getFarmer() {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simple-jpa-application");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();

        List list = entityManager.createQuery("from Farmer")
                .getResultList();

        System.out.println("resultList = " + list);

        return ResponseEntity.ok().body(list);
    }
}
