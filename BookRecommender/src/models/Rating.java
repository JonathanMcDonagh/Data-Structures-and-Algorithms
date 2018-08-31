//Author - Jonathan McDonagh / June 2018
package models;

import static com.google.common.base.MoreObjects.toStringHelper;
import com.google.common.base.Objects;

public class Rating {
	static long counter = 1l;
	
	public long id; 
	public long userId;
	public long bookId;
	public double rating;
	
	public Rating(long userId, long bookId, double rating){
		this.id = counter++;
		
		this.userId = userId;
		this.bookId = bookId;
		this.rating = rating;
	}
	
	@Override
	public String toString(){
		return toStringHelper(this).addValue(userId)
				                   .addValue(bookId)
				                   .addValue(rating)
				                   .toString();
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof Rating){
			final Rating other = (Rating) obj;
			return Objects.equal(userId, other.userId)
					&& Objects.equal(bookId, other.bookId)
					&& Objects.equal(rating, other.rating);
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return Objects.hashCode(this.userId, this.bookId, this.rating);
	}
}
