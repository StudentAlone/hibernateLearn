package RelationalMapping.OneToOne;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity(name = "Person")
@Table(name="PersonOneToMany")
public class Person {

	    @Id
	    @GeneratedValue
	    private Long id;
	    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Phone> phones =null;

	    public Person() {
	    }

	    public List<Phone> getPhones() {
	        return phones;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setPhones(List<Phone> phones) {
			this.phones = phones;
		}
	    
}
