package Register;

import javax.ws.rs.core.MediaType;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


;

@Path("/employers")
@RequestScoped
public class RegisterRestService {
	
	@Inject
	private RegisterJpa registerJpa;
	
	@GET
	@Path("/{index:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("index") long index) {
		return registerJpa.getPerson(index);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addPerson(Person person) {
		registerJpa.addPerson(person);
	}
	
}
