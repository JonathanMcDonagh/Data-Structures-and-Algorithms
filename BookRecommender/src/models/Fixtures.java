package models;

public class Fixtures {
	
	public static User[] users = {
			new User("Jonathan", "McDonagh", "M", "20", "Student"),
			new User("Lauren", "Scally", "F", "21", "Student")
	};
	
	public static Book[] books ={
			new Book("ManagingOneself", "2006", "PeterDrucker"),
			new Book("TheOneThing", "2013", "GaryKeller")
	};
	
	public static Rating[] ratings ={
			new Rating(1, 1, 1.0),
			new Rating(2, 2, 2.0)
	};
}
