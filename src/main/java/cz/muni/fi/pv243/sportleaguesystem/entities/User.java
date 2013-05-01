package cz.muni.fi.pv243.sportleaguesystem.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
*
* @author Filip Bogyai
*/
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
    
    @NotNull
    @Size(min = 1, max = 20)
    @Pattern(regexp = "[A-Za-z]+", message = "must contain only letters")
    private String firstName;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Pattern(regexp = "[A-Za-z]+", message = "must contain only letters")
    private String lastName;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Digits(fraction = 0, integer = 20)
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @ManyToMany(mappedBy="players")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<League> leagues;
            
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
	@Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if (this.id != null && !Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
