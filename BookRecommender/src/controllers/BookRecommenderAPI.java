//Author - Jonathan McDonagh / June 2018
package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import models.Rating;
import models.User;
import models.Book;

import utils.DataInput;
import utils.Serializer;

public class BookRecommenderAPI implements Recommender {

	public Map<Long, User> userIndex = new HashMap<>();
	public Map<Long, Book> bookIndex = new HashMap<>();
	public Map<Long, Rating> ratingIndex = new HashMap<>();
	
	private Serializer serializer;
	Rating rating;

	//Empty constructor for the api
	public BookRecommenderAPI(){ }
	
	//Constructor for Serializer
	public BookRecommenderAPI(Serializer serializer){
		this.serializer = serializer;
	}
	
	//method used to load data from serializer
	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		serializer.read();
		ratingIndex		= (Map<Long, Rating>)	serializer.pop();
		bookIndex		= (Map<Long, Book>)		serializer.pop();
		userIndex		= (Map<Long, User>)		serializer.pop();	
	}

	//method used to save the data
	public void write() throws Exception {
		serializer.push(userIndex);
		serializer.push(bookIndex);
		serializer.push(ratingIndex);
		serializer.write();	
	}
	
	//Loads data from file
	public void prime() throws Exception {
		DataInput loader = new DataInput();
		List<User> users = loader.loadUsers("data/users5.dat");
		for (User user : users) {
			userIndex.put(user.id, user);
		}

		List<Book> books = loader.loadBooks("data/items5.dat");
		for (Book book : books) {
			bookIndex.put(book.id, book);
		}

		List<Rating> ratings = loader.loadRatings("data/ratings5.dat");
		for (Rating rating : ratings) {
			addRating(rating.userId, rating.bookId, rating.rating);
		}
	}
	
		/* USER */
	
	//Adds user
	public User addUser(String firstName, String lastName, String gender, String age, String occupation) {
		User user = new User(firstName, lastName, gender, age, occupation);
		user.id = userIndex.size() + 1l;
		userIndex.put(user.id, user);
		return user;
	}
	
	//Removes a user
	public void removeUser(Long userID) throws Exception{
		userIndex.remove(userID);
	}
	
	//Gets  user based on ID
	public User getUser(Long id){
		return userIndex.get(id);
	}
	
	//Gets list of users
	public Collection<User> getUsers(){
		return userIndex.values();
	}
	
		/* BOOK */
	
	//Adds book
	public Book addBook(String title, String year, String author) {
		Book book = new Book(title, year, author);
		book.id = bookIndex.size() + 1l;
		bookIndex.put(book.id, book);
		return book;
	}
	
	//Removes book based on bookID
	public void removeBook(Book book) throws Exception{
		bookIndex.remove(book.id);	
	}
	
	//Gets book based on ID
	public Book getBook(long bookID) {	
		return bookIndex.get(bookID);	
	}
	
	//Gets collection of books
	public Collection<Book> getBooks(){
		return bookIndex.values();
	}
	
	//Lists top 5 books
	 public List<Book>getTopFiveBook(){
	 	List <Book> fivebooks = new ArrayList <Book> (bookIndex.values());	
		Collections.sort (fivebooks);

		Collections.reverse(fivebooks);
		return fivebooks.subList(0,Math.min (fivebooks.size(),5));
	 }
	 
	
		/* RATING */
	
	//Adds Rating on bookId by user based on the userId
	public Rating addRating(long userID, long bookID, double rating) {
		Rating r = new Rating(userID, bookID, rating);
		r.id = ratingIndex.size() + 1l;
		ratingIndex.put(r.id, r);
		return r;	
	}
	
	//Gets rating for book
	public Rating getRating(long bookId){
		return ratingIndex.get(bookId);
	}

	//Gets list of ratings
	public Collection<Rating> getRatings(){
		return ratingIndex.values();
	}
}
	
	
