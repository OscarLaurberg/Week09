
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

    Customer c1 = new Customer("Derp","Derpsen@derp.dk");
    Customer c2 = new Customer("Jim", "jim@jim.dk");
    ItemType itemType1 = new ItemType("Snescooter", "mega sprød", 99);
    ItemType itemType2 = new ItemType("Karse", "Hjemmegroet", 6);

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
}