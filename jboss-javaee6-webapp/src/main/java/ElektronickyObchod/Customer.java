package ElektronickyObchod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private long id;
	
	private String customerName;
	
	private int maxDayLimit;
	
	private int discount;
	
	public Customer(){
		
	}	

	public Customer(String customerName, int maxDayLimit, int discount) {
		super();
		this.customerName = customerName;
		this.maxDayLimit = maxDayLimit;
		this.discount = discount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getMaxDayLimit() {
		return maxDayLimit;
	}

	public void setMaxDayLimit(int maxDayLimit) {
		this.maxDayLimit = maxDayLimit;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
	
	
}
