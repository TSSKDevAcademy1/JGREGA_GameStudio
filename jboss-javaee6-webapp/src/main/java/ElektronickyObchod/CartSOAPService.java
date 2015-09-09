package ElektronickyObchod;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jws.WebService;

@Singleton
@WebService(name="CartSOAP")
public class CartSOAPService {

	@Inject
	private CartJpa cartjpa;
	
	public void addCart(long customerId, long productId, long categoryId, int productQuantity){
		cartjpa.addCart(customerId,productId,categoryId,productQuantity);
	}
	
	public Cart getCart(long index){
		return cartjpa.getCart(index);
	}
	
	public void payBill(long idZakaznika, String date){
		cartjpa.payBill(idZakaznika,date);
	}
	
}
