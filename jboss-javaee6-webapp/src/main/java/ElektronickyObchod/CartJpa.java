package ElektronickyObchod;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@Stateless
public class CartJpa {

	private String productName;
	@Inject
	private EntityManager em;
	
	@Inject
	private Cart cart;
	
	@Inject
	private TotalValue totalValue;
	
	private int totalPrize = 0;
	
//	private List<Integer> nakup = new ArrayList<>();
	
	public void addCart(long customerId, long productId, long categoryId, int productQuantity){
//		productName = (String) em.createQuery("select productName from Product WHERE id = :id")
//				 .setParameter("id",productId).getSingleResult();	
		
		cart.setProductName(em.find(Product.class, productId).getProductName());
		cart.setProductValue(em.find(Product.class, productId).getPrize());
		cart.setCategoryName(em.find(Category.class, categoryId).getName());
		cart.setCustomerName(em.find(Customer.class, customerId).getCustomerName());
		cart.setCustomerId(customerId);
		cart.setProductId(productId);
		cart.setCategoryId(categoryId);
		cart.setproductQuantity(productQuantity);
		em.persist(cart);
	}
	
	public Cart getCart(long index){
		return em.createQuery("select c from Cart c WHERE c.id = :id", Cart.class).setParameter("id",index).getSingleResult();		
	}

	@SuppressWarnings("unchecked")
	public void payBill(long idZakaznika,String date) {	
		totalValue.setIdZakaznika(idZakaznika);
		
		List <Integer> nakup = em.createQuery("select productValue from Cart WHERE customerId = :customerId")
								.setParameter("customerId",idZakaznika).getResultList();
		
		List <Integer> quantity = em.createQuery("select productQuantity from Cart WHERE customerId = :customerId")
				.setParameter("customerId",idZakaznika).getResultList();
		
		for(int i = 0; i < nakup.size();i++){
			totalPrize = totalPrize + nakup.get(i) * quantity.get(i);
		}
		System.out.println(totalPrize);
		
		totalValue.setIdZakaznika(idZakaznika);
		totalValue.setCenaNakupu(totalPrize);
		totalValue.setDate(date);
		
		em.persist(totalValue);
	}
	
}
