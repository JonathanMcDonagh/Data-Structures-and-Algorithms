//Author - Jonathan McDonagh / June 2018
package controllers;

import static org.junit.Assert.*;

import static models.Fixtures.users;
import static models.Fixtures.books;
import static models.Fixtures.ratings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import models.Fixtures;
import models.Book;
import models.User;
import models.Rating;

public class BookRecommenderAPITest {

	Fixtures fixtures;
	BookRecommenderAPI bookAPI;
	
	@Before
	public void setup(){
		bookAPI = new BookRecommenderAPI();
		for(User user : users){
			bookAPI.addUser(user.firstName, user.lastName, user.gender, user.age, user.occupation);
		}
		
		for(Book book : books){
			bookAPI.addBook(book.title, book.year, book.author);
		}
		
		for(Rating rating : ratings){
			bookAPI.addRating(rating.userId, rating.bookId, rating.rating);
		}
	}
	
	@After
	public void tearDown(){
		bookAPI = null;
	}
	
	@Test
	public void testAddUser(){
		assertEquals(users.length, bookAPI.getUsers().size());
		bookAPI.addUser("Lauren", "Scally", "F", "21", "Student");
		assertEquals(users.length +1, bookAPI.getUsers().size());
	}
	
	@Test
	public void testAddBook(){
		assertEquals(books.length, bookAPI.getBooks().size());
		bookAPI.addBook("ManagingOneself", "2008", "PeterDrucker");
		assertEquals(books.length+1, bookAPI.getBooks().size());
	}

	
	@Test
	public void testAddRating(){
		assertEquals(ratings.length, bookAPI.getRatings().size());
		bookAPI.addRating(1, 1, 1.0);
		assertEquals(ratings.length +1, bookAPI.getRatings().size());
	}
}
