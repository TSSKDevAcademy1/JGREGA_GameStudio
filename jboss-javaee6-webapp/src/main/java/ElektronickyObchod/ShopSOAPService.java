package ElektronickyObchod;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;


@Singleton
@WebService(name="ShopSOAP")
public class ShopSOAPService {
	
	@Inject
	private CategoryJpa categoryjpa;
	
	@Inject
	private ProductJpa productjpa;
	
	@Inject 
	private CustomerJpa customerjpa;
	
	public void addCategory(Category category){
		categoryjpa.addCategory(category);
	}
	
	public void addProduct(Product product){
		productjpa.addProduct(product);
	}
	
	public void addCustomer(Customer customer){
		customerjpa.addCustomer(customer);
	}

	public Category getCategory(long index) {
		return categoryjpa.getCategory(index);
	}
	
	public Customer getCustomer(long index) {
		return customerjpa.getCustomer(index);
	}

	
}

//@Singleton
//@WebService(name="RegisterSOAP")
//public class RegisterSOAPService {
//	
//	@Inject
//	private RegisterJpa registerJpa;
//
//	public Person getPerson(long index) {
//		return registerJpa.getPerson(index);
//	}
//	public void addPerson(Person person) {
//		registerJpa.addPerson(person);
//	}
//	public void removePerson(Person person) {
//		registerJpa.removePerson(person);
//	}
//	public void setPerson(Person person, long index) {
//		registerJpa.setPerson(person, index);
//	}
//	public Person findPersonByName(String name) throws Exception {
//		return registerJpa.findPersonByName(name);
//	}		
//}