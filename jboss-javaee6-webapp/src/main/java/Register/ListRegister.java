package Register;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

// Trieda pre pracu s List-om
@Singleton
public class ListRegister implements Serializable, Iterable<Person>, RegisterSerial{

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

	/* (non-Javadoc)
	 * @see Register.RegisterWebService#getPerson(int)
	 */
	@Override
	public Person getPerson(int index) {
		List<Person> persons = em.createQuery("select p from Person p", Person.class).getResultList();
		Collections.sort(persons);
		return persons.get(index);
	}

	public void setPerson(Person person, int a) {
		persons.set(a, person);
	}

	/* (non-Javadoc)
	 * @see Register.RegisterWebService#addPerson(Register.Person)
	 */
	@Override
	public void addPerson(Person person) {
		persons.add(person);
		
//		EntityTransaction transaction  = em.getTransaction();
//    	transaction.begin();
		
		em.persist(person);
		
//		transaction.commit();    	
    	
//    	em.close();
//    	factory.close();
	}

	public Person findPersonByName(String name) throws Exception {
		return persons.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
	}

	public Person findPersonByPhoneNumber(String phoneNumber) throws Exception {
		for (int i = 0; i < persons.size(); i++) {
			if (phoneNumber.equals(persons.get(i).getPhoneNumber())) {
				return persons.get(i);
			}
		}
		throw new Exception("Person with this phone number NOT FOUND!!");
	}

	/* (non-Javadoc)
	 * @see Register.RegisterWebService#removePerson(Register.Person)
	 */
	@Override
	public void removePerson(Person person) {
		for (int i = 0; i < persons.size(); i++) {
			if (person.equals(persons.get(i))) {
				persons.remove(i);
			}
		}
	}
}
