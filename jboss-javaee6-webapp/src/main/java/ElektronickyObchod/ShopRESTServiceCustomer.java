package ElektronickyObchod;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/customer")
@RequestScoped
public class ShopRESTServiceCustomer {
	
	@Inject
	private CustomerJpa customerjpa;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addCustomer(Customer customer){
		customerjpa.addCustomer(customer);
	}
	
	@GET
	@Path("/{index:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(long index) {
		return customerjpa.getCustomer(index);
	}
}

