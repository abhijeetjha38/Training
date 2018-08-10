package JpsAssociation;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@DiscriminatorColumn(name="acct_name",discriminatorType=DiscriminatorType.STRING)
public abstract class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id  ;
    float balance ; 
    @ManyToOne
    @JoinColumn(name="cust_id")
    
    Customer customer ; 
    
    public Account() {
        
    }
    public Account(float balance2) {
        balance = balance2 ;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void setCustomer(Customer tt)
    {
    	this.customer = tt;
    }
    public Customer getCustomer()
    {
    	return this.getCustomer();
    }
}
