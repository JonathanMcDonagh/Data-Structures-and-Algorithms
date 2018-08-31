//Author - Jonathan McDonagh / June 2018
package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import utils.Serializer;
import utils.XMLSerializer;

import models.User;
import models.Book;
import models.Rating;

public class Main {
	
	public BookRecommenderAPI bookAPI;
	private User user;
	private Book book;
	private Rating rating;
	
	public Main() throws Exception{	
		//Loads datastore file
		File datastore = new File("bookdata.xml");
		Serializer serializer = new XMLSerializer(datastore);
		
		bookAPI = new BookRecommenderAPI(serializer);
		if(datastore.isFile()){
			bookAPI.load();
		}
	}
	
	//Console
	public static void main(String[] args) throws Exception{
		Main main = new Main();
		Shell shell = ShellFactory.createConsoleShell("Books4u",  "Welcome to Books4u \n ?help or ?list for more (Try 'ld' to load data)", main);
		
		shell.commandLoop();
		main.bookAPI.write();
		main.bookAPI.prime();
	}
	
	//Loads Book data
	@Command(description="Load data", abbrev="ld")
	public String load() throws Exception{
		bookAPI.prime();
		return "Bookdata was Loaded";
	}
	
	//Saves Book data
	@Command(description="Save data", abbrev="sd")
	public String save() throws Exception{
		bookAPI.write();
		return "Bookdata was Saved";
	}
	
		/* USER */
	
	//Adds user
	@Command(description="Add a new user", abbrev="au" )
	public String addUser(@Param(name="first name") String firstName,
										@Param(name="last name") String lastName,
										@Param(name="age") String age,
										@Param(name="gender") String gender,
										@Param(name="occupation") String occupation){
		user = bookAPI.addUser(firstName, lastName, gender, age, occupation);
		return "\n The User: " + user.firstName + " was added.";
	}
	
	//Removes User based on userID
	@Command(description="Remove a user", abbrev="ru")
	public void removeUser(@Param(name="userID") long userID) throws Exception{	
		User user = bookAPI.getUser(userID);
		bookAPI.removeUser(userID);
		System.out.println("\n The User: " + user.firstName + " was removed.");	
	}
	
	//Gets user based on userID
	@Command(description="Get a specific user", abbrev="gu")
	public String getUser(@Param(name="userID") long userID){
		user = bookAPI.getUser(userID);
		return user.toString();
	}
	
	//Gets list of users
	@Command(description="Get List of Users", abbrev="gu")
	public void getUsers(){
		Collection<User>users = bookAPI.getUsers();
		System.out.println(users);
	}
	
		/* BOOK */
	
	//Adds book
	@Command(description="Add a new book", abbrev="ab")
	public String addBook(@Param(name="title") String title,
									@Param(name="year") String year,
									@Param(name="Author") String author){		
		book = bookAPI.addBook(title, year, author);
		return "\n The Book: " + book.title + " was added to the list";
	}
		
	//Removes book based on BookID
	@Command(description="Remove a book", abbrev="rb")
	public void removeBook(@Param(name="bookID") long bookID) throws Exception{
		Book book = bookAPI.getBook(bookID);
		bookAPI.removeBook(book);
		System.out.println("\nBook: " + book.title + " removed.");
	}
	
	//Gets book based on BookID
	@Command(description="Get a specific book", abbrev="gb")
	public String getBook(@Param(name="bookID") long bookID){
		book = bookAPI.getBook(bookID);
		return book.toString();	
	}
		
	//Gets the list of Books
	@Command(description="Get List of Books", abbrev="gb")
	public void getBooks(){
		Collection<Book>books = bookAPI.getBooks();
		System.out.println(books);
	}
	
	//Get top five books
	@Command(description="Get top five books", abbrev="gtfb")
	public void getTopFiveBooks(){
		ArrayList<Book> books = new ArrayList<>(bookAPI.getTopFiveBook());
		if(books.size()>0){
			for(Book book : books){
				System.out.println(book.toString());
			}
		}else{
			System.out.println("No top books to show");
		}
	}
	
		/* RATING */
	
	//Adds rating to book by user
	@Command(description="Add a Rating", abbrev="ar")
	public String addRating(@Param(name="userID") long userID, @Param(name="bookID") long bookID, @Param(name="rating") double rating){
		bookAPI.addRating(userID, bookID, rating);
		book = bookAPI.getBook(bookID);
		user = bookAPI.getUser(userID);
		return "Book " + book.title + " Rated " + rating + " by " + user.firstName;
	}
	
	//Gets all ratings
	@Command(description="Get all ratings", abbrev="gr")
	public void getRatings(){
		Collection<Rating> ratings = bookAPI.getRatings();
		System.out.println(ratings);
	}
	
	//Gets rating based on id
	@Command(description="Get a Rating based on id", abbrev="gr")
	public String getRating(@Param(name="id") long id){
		rating = bookAPI.getRating(id);
		return rating.toString();
	}
	
}
