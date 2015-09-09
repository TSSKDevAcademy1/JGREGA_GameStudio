package ElektronickyObchod;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class CustomerJpa {

	@Inject
	private EntityManager em;
	
	public void addCustomer(Customer customer){
		em.persist(customer);
	}
	
	public Customer getCustomer(long index) {
		return em.createQuery("select c from Customer c WHERE c.id = :id", Customer.class).setParameter("id",index).getSingleResult();
	}	
	
//	public Customer(String customerName, int maxDayLimit, int discount) {
//		super();
//		this.customerName = customerName;
//		this.maxDayLimit = maxDayLimit;
//		this.discount = discount;
//	}
}
