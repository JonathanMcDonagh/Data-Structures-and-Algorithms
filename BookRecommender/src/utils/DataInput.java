//Author - Jonathan McDonagh / June 2018
package utils;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.In;
import models.User;

import models.Book;

import models.Rating;


public class DataInput {
	
	//CSV for Users
	public List<User> loadUsers(String filename) throws Exception{
		File usersFile = new File(filename);
		In inUsers = new In(usersFile);
		
		String delims = "[|]";
		List<User> users = new ArrayList<User>();
		while(!inUsers.isEmpty()){
			String userDetails = inUsers.readLine();
			String[] userTokens = userDetails.split(delims);
			if(userTokens.length == 7){
				Long id 		  = Long.parseLong(userTokens[0]);
				String firstName  = userTokens[1];
				String lastName	  = userTokens[2];
				String age		  = userTokens[3];
				String gender	  = userTokens[4];
				String occupation = userTokens[6];
				
				users.add(new User(id, firstName, lastName, gender, age, occupation));					
			}else{
				throw new Exception("Invalid member length: " + userTokens.length);
			}
		}
		return users;
	}

	//CSV for Books
	public List<Book> loadBooks (String filename) throws Exception{
		File booksFile = new File(filename);
		In inBooks = new In(booksFile);
		
		String delims = "[|]";
		List<Book> books = new ArrayList<Book>();
		while(!inBooks.isEmpty()){
			String bookDetails = inBooks.readLine();
			String[] bookTokens = bookDetails.split(delims);
			if(bookTokens.length == 23){
				String title		= bookTokens[1];
				String year			= bookTokens[2];
				String author		= bookTokens[3];
				books.add(new Book(title, year, author));
			}else{
				throw new Exception("Invalid book length: " + bookTokens.length);
			}
		}
		return books;
	}
	
	//CSV for Ratings
	public List<Rating> loadRatings (String filename) throws Exception{
		File ratingsFile = new File(filename);
		In inRatings = new In(ratingsFile);
		
		String delims = "[|]";
		List<Rating> ratings = new ArrayList<Rating>();
		while(!inRatings.isEmpty()){
			String ratingDetails = inRatings.readLine();
			String[] ratingTokens = ratingDetails.split(delims);
			if(ratingTokens.length == 4){
				long userId 	= Long.parseLong(ratingTokens[0]);
				long bookId	= Long.parseLong(ratingTokens[1]);
				int rating   = Integer.parseInt(ratingTokens[2]);
				
				ratings.add(new Rating(userId, bookId, rating));	
			}else{
				throw new Exception("Invalid ratings length: " + ratingTokens.length);
			}
		}
		return ratings;
	}
}
