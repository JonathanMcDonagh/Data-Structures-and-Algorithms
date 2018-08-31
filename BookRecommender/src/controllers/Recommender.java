//Author - Jonathan McDonagh / June 2018
package controllers;

import models.Book;
import models.Rating;
import models.User;

import java.util.Collection;
import java.util.List;

public interface Recommender {
	
	public void load() throws Exception;
	public void prime() throws Exception;
	public void write() throws Exception;
	
	public User addUser(String firstName,String lastName,String gender,String age,String occupation);
	public void removeUser(Long id) throws Exception;
	User getUser(Long id);
	Collection<User> getUsers();

	public Book addBook(String title, String year, String author);
	public Book getBook(long bookID);
	void removeBook(Book book) throws Exception;
	Collection<Book> getBooks();
	public List<Book> getTopFiveBook();
	
	public Rating addRating(long userID,long bookID,double rating);
	Rating getRating(long bookId);
	Collection<Rating> getRatings();
	
}