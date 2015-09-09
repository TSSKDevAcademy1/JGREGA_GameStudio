package Register;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class RegisterJpa {
	@Inject
	private EntityManager em;
	
	private List<Person> persons = new ArrayList<Person>();

	public Iterator<Person> iterator() {
		return persons.iterator();
	}

	public int getCount() {
		return persons.size();
	}
	
	public int getSize(){
		return persons.size();
	}
	
	// Update osoby
	public void setPerson(Person person, long index) {
		
		// nejde
//		em.createQuery("UPDATE Person SET name = :name AND phoneNumber = :phoneNumber WHERE id = :id",Person.class)
//		.setParameter("name",person.getName())
//		.setParameter("phoneNumber", person.getPhoneNumber())
//		.setParameter("id", index).executeUpdate();
		
		Person pers = em.find(Person.class, index);
		pers.setName(person.getName());
		pers.setPhoneNumber(person.getPhoneNumber());
	}

	// najde osobu podla indexu
	public Person getPerson(long index) {
		return em.createQuery("select p from Person p WHERE p.id = :id", Person.class).setParameter("id",index).getSingleResult();
	}

	// pridanie osoby do databazy
	public void addPerson(Person person) {
		em.persist(person);
	}

	// najde osobu podla mena
	public Person findPersonByName(String name) throws Exception {
		return em.createQuery("select p from Person p Where name = :name",Person.class).setParameter("name", name).getSingleResult();
	}

	public Person findPersonByPhoneNumber(String phoneNumber) throws Exception {
		for (int i = 0; i < persons.size(); i++) {
			if (phoneNumber.equals(persons.get(i).getPhoneNumber())) {
				return persons.get(i);
			}
		}
		throw new Exception("Person with this phone number NOT FOUND!!");
	}


	public void removePerson(Person person) {
		for (int i = 0; i < persons.size(); i++) {
			if (person.equals(persons.get(i))) {
				persons.remove(i);
			}
		}
	}
}

