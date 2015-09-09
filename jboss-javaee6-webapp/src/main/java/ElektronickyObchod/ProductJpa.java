package ElektronickyObchod;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class ProductJpa {

	@Inject
	private EntityManager em;
	
	public void addProduct(Product product){
		em.persist(product);
	}
}
	
	
