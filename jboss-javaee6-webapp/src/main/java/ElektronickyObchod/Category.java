package ElektronickyObchod;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
	
	private String categoryName;	

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category() {
		
	}

	public String getName() {
		return categoryName;
	}

	public void setName(String name) {
		this.categoryName = name;
	}
	
	
	
}
