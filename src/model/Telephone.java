package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telephone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	private String telephone;

	
	// constructors
	public Telephone(String telephone) {
	    this.telephone = telephone;
	}
	public Telephone() {
		
	}
	
	//gets and sets 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Telephone [id=" + id + ", telephone=" + telephone + "]";
	}



	

}