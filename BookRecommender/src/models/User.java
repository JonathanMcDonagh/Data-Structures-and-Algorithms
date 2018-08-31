//Author - Jonathan McDonagh / June 2018
package models;

import static com.google.common.base.MoreObjects.toStringHelper;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class User {
	static Long counter= 1l;
	
	public Long id;
	public String firstName;
	public String lastName;
	public String gender;
	public String age;
	public String occupation;
	
	public List<Rating> ratings = new ArrayList<>();
	
	public User(String firstName, String lastName, String gender, String age, String occupation){
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender	= gender;
		this.age = age;
		this.occupation = occupation;
	}

	public User(Long id, String firstName, String lastName, String gender, String age, String occupation){
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender	= gender;
		this.age = age;
		this.occupation = occupation;
	}
	
	public String toString(){
		return toStringHelper(this).addValue(id)
								   .addValue(firstName)
								   .addValue(lastName)
								   .addValue(gender)
								   .addValue(age)
								   .addValue(occupation)
								   .toString();
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof User){
			final User other = (User) obj;
			return Objects.equal(firstName, other.firstName)
					&& Objects.equal(lastName, other.lastName)
					&& Objects.equal(gender, other.gender)
					&& Objects.equal(age, other.age)
					&& Objects.equal(occupation, other.occupation)
					&& Objects.equal(ratings, other.ratings);
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return Objects.hashCode(this.lastName, this.firstName, this.age, this.gender, this.occupation);
	}
}
