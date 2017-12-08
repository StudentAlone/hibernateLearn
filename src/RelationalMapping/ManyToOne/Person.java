package RelationalMapping.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Person")
public class Person {

	 @Id  
	    @GeneratedValue(generator="id")  
	    @GenericGenerator(name="id",strategy="assigned")
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person() {
    }

}