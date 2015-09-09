package ElektronickyObchod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long id;
	
	private String productName;
	
	private String categoryName;
	
	private String customerName;
	
	private int productValue;
	
	private int productQuantity;
	
	private long customerId;
	
	private long productId;
	
	private long categoryId;
	
	public Cart(){
		
	}

	public Cart(String productName, String categoryName, String customerName, int productValue, int productQuantity,
			long customerId, long productId, long categoryId) {
		super();
		this.productName = productName;
		this.categoryName = categoryName;
		this.customerName = customerName;
		this.productValue = productValue;
		this.productQuantity = productQuantity;
		this.customerId = customerId;
		this.productId = productId;
		this.categoryId = categoryId;
	}	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getProductValue() {
		return productValue;
	}

	public void setProductValue(int productValue) {
		this.productValue = productValue;
	}

	public int getproductQuantity() {
		return productQuantity;
	}

	public void setproductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
	
	
	
}
