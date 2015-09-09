package ElektronickyObchod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TotalValue {

	@Id
	@GeneratedValue
	private long id;
	
	private int cenaNakupu;
	
	private long idZakaznika;
	
	private String date; //  v tvare den.mesiac.rok
	
	public TotalValue(int cenaNakupu, long idZakaznika,String date){
		this.cenaNakupu = cenaNakupu;
		this.idZakaznika = idZakaznika;
		this.date = date;
	}
	
	public TotalValue(){
		
	}

	public long getIdZakaznika() {
		return idZakaznika;
	}

	public int getCenaNakupu() {
		return cenaNakupu;
	}

	public void setCenaNakupu(int cenaNakupu) {
		this.cenaNakupu = cenaNakupu;
	}

	public void setIdZakaznika(long idZakaznika) {
		this.idZakaznika = idZakaznika;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
