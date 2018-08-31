//Author - Jonathan McDonagh / June 2018
package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;

import com.google.common.base.Objects;

public class Book implements Comparable<Book>{
	static Long	counter = 1l;
	
	public Long id;
	public String title;
	public String year;
	public String author;
	public List<Rating> ratings = new ArrayList<Rating>();
	
	public Book(String title, String year, String author){
		this.id = counter ++;
		this.title = title;
		this.year = year;
		this.author = author;
	}
	
	public Book(String title, String year, String author, List<Rating> ratings){
		this.id = counter ++;
		this.title = title;
		this.year = year;
		this.author = author;
		this.ratings=ratings;
	}
	
	@Override
	public String toString(){
		return toStringHelper(this).addValue(id)
				                   .addValue(title)
				                   .addValue(year)
				                   .addValue(author)
				                   .toString();
	}
	
	@Override
	public boolean equals(final Object obj){
		if (obj instanceof Book){
			final Book other = (Book) obj;
			return Objects.equal(title, other.title)
					&& Objects.equal(year, other.year)
					&& Objects.equal(author, other.author);
		}else{
			return false;
		}
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(this.id, this.title, this.author);
	}
	
	public int compareTo(Book book) {
		return this.title.compareTo(book.title);
	}

}
