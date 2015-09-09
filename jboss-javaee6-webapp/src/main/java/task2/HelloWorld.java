package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService
public class HelloWorld {

	private List<Student> students = new ArrayList<>();

	public HelloWorld() {

		students.add(new Student("Jano", 24));
		students.add(new Student("Milan", 36));
	}

	public String sayHello() {
		return "Hello World";
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public String sayHelloTo(String name) {
		return "Hello" + name;
	}

	public List<Student> getStudentsStartingWith(String prefix) {

		return students.stream().filter(s -> s.getName().startsWith(prefix)).collect(Collectors.toList());

	}
}
