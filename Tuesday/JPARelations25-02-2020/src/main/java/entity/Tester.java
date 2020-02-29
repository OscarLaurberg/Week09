/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author oscar
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        List<String> c1h = new ArrayList();
        c1h.add("Syning");
        c1h.add("cykling");
        List<String> c2h = new ArrayList();
        c2h.add("Basketball");
        c2h.add("Badminton");
        Customer c1 = new Customer("John", "Doe", c1h);
        Customer c2 = new Customer("Jane", "Doe", c2h);
        c1.addPhone("29803002","Home");
        c1.addPhone("36954310","Work");
        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
