/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Customer;
import entities.ItemType;
import entities.Order;
import entities.OrderLine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author oscar
 */
public class Facade {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pu");
    private static EntityManager em;

    public Customer createCustomer(String name, String email) {
        Customer cust = new Customer(name, email);
        em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public Customer findCustomer(int id) {
        em = EMF.createEntityManager();
        try {
            Customer cust = em.find(Customer.class, (long) id);
            return cust;
        } finally {
            em.close();
        }
    }

    public List<Customer> getAllCustomers() {
        em = EMF.createEntityManager();
        try {
            TypedQuery q = em.createQuery("SELECT c FROM Customer c", Customer.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ItemType createItemType(String name, String description, int price) {
        em = EMF.createEntityManager();
        ItemType it = new ItemType(name, description, price);
        try {
            em.getTransaction().begin();
            em.persist(it);
            em.getTransaction().commit();
            return it;
        } finally {
            em.close();
        }
    }

    public ItemType findItemType(int id) {
        em = EMF.createEntityManager();
        try {
            ItemType it = em.find(ItemType.class, (long) id);
            return it;

        } finally {
            em.close();
        }

    }

    public Order createOrder(Order order) {
        em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
            return order;
        } finally {
            em.close();
        }
    }

    public List<Order> getCustomerOrders(Integer customerID) {
        return findCustomer(customerID).getOrders();
    }
    
        public Order getOrder(int id) {
        em = EMF.createEntityManager();
        try {
            return em.find(Order.class,(long) id);
        } finally {
            em.close();
        }
    }

       public int getOrdersTotalPrice(Integer orderId) {
        return getOrder(orderId).getTotalPrice();
    }
}
