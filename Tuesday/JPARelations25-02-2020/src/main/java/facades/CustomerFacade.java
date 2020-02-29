/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author oscar
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;

    private CustomerFacade() {

    }

    public static CustomerFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Customer addCustomer(int id) {
        EntityManager em = getEntityManager();
        Customer customer = em.find(Customer.class, id);
        return customer;
    }

    public Customer addCustomer(Customer cust) {
        Customer customerToBeAdded = new Customer(cust.getFirstName(), cust.getLastName());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customerToBeAdded);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return customerToBeAdded;
    }
    
    public Customer deleteCustomer(int id){
        EntityManager em = getEntityManager();
        Customer customer = em.find(Customer.class, id);
        try{
            em.getTransaction().begin();
            em.remove(customer);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return customer;
    }
    
    public List<Customer> getAllCustomers(){
        EntityManager em = getEntityManager();
        TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> allCustomers = q.getResultList();
        return allCustomers;
    }
    
}
