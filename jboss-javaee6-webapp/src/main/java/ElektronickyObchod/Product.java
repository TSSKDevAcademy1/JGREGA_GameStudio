package ElektronickyObchod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String productName;
	
	private int prize;
	
	private int category;
	
	public Product(){
		
	}	

	public Product(String productName, int prize, int category) {
		super();
		this.productName = productName;
		this.prize = prize;
		this.category = category;	
	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	
}
