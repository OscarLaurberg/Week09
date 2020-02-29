
import entities.Customer;
import entities.ItemType;
import entities.Order;
import entities.OrderLine;
import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oscar
 */
public class Main {
    
           
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pu");
    private static EntityManager em;

    public static void main(String[] args) {
   
        
        Facade facade = new Facade();

    Customer c1 = new Customer("Niels", "niller@123.dk");
    Customer c2 = new Customer("Peter", "pet@123.dk");
    ItemType itemType1 = new ItemType("Item 1", "This is the first item", 10);
    ItemType itemType2 = new ItemType("Item 2", "This is some other item", 20);

    facade.createCustomer(c1);
    facade.createCustomer(c2);
    
    facade.createItemType("Dildo SwagginZ","Derp",1000);
    facade.createItemType("SkankHunt42", "Gerald", 99);
    


    Order order = new Order();
    OrderLine ol1 = new OrderLine(10, itemType1);
    OrderLine ol2 = new OrderLine(41, itemType2);

    order.addOrderLine(ol1);
    order.addOrderLine(ol2);
    
    c1.addOrder(order);
    facade.createOrder(order);
    
    
}
