package JpsAssociation;

import java.sql.* ;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.* ;
@Entity
public class Customer {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	int id;
	String firstName,middleName,lastName ;
	
	Date dateOfJoin ;
	
	public Customer(int id, String firstName, String middleName, String lastName, Date dateOfJoin,
			List<Account> accounts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfJoin = dateOfJoin;
		this.accounts = accounts;
	}
	public Customer() {
		
	}
	
	@OneToMany( mappedBy="Cust_id" )
	List<Account> accounts = new  ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	

}
