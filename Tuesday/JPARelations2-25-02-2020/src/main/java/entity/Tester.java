/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author oscar
 */
public class Tester {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Persistence.generateSchema("pu", null);

        try {
            Customer c1 = new Customer("John", "Doe");
            Customer c2 = new Customer("Jane", "Doe");
            Address a1 = new Address ("a1","a1");
            c1.addAddress(new Address("Joey Moe Ave.", "Down Town"));
            c1.addAddress(new Address("Joey Moe Ave.2", "Down Town2"));
            c2.addAddress(new Address("Burhan Børge Boulevard", "Bronx"));
            c1.addAddress(a1);
            c2.addAddress(a1);

            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
