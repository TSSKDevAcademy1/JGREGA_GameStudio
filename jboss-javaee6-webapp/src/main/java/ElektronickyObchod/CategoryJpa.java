package ElektronickyObchod;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import Register.Person;

@Stateless
public class CategoryJpa {

	@Inject
	private EntityManager em;
	
	public void addCategory(Category categoryName) {
		em.persist(categoryName);
	}
	
	public Category getCategory(long index) {
		return em.createQuery("select c from Category c WHERE c.id = :id", Category.class).setParameter("id",index).getSingleResult();
	}
}
