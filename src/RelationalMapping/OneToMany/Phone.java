package RelationalMapping.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Phone")
@Table(name="PhoneOneToMany")
public class Phone {

	    @Id
	    @GeneratedValue
	    private Long id;

	    @Column(name = "number")
	    private String number;

	    public Phone() {
	    }

	    public Phone(String number) {
	        this.number = number;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getNumber() {
	        return number;
	    }
}
