package Register;

import javax.ejb.Local;
import javax.inject.Inject;

@Local
public interface RegisterSerial {

	Person getPerson(int index);

	void addPerson(Person person);

	void removePerson(Person person);

}