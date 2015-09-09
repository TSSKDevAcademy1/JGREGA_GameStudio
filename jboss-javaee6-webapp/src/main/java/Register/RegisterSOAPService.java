package Register;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;

@Singleton
@WebService(name="RegisterSOAP")
public class RegisterSOAPService {
	
	@Inject
	private RegisterJpa registerJpa;

	public Person getPerson(long index) {
		return registerJpa.getPerson(index);
	}

	public void addPerson(Person person) {
		registerJpa.addPerson(person);
	}

	public void removePerson(Person person) {
		registerJpa.removePerson(person);
	}

	public void setPerson(Person person, long index) {
		registerJpa.setPerson(person, index);
	}

	public Person findPersonByName(String name) throws Exception {
		return registerJpa.findPersonByName(name);
	}	
	
	
	
}
