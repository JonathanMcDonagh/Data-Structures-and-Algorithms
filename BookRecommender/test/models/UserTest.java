//Author - Jonathan McDonagh / June 2018
package models;

import static org.junit.Assert.*;
import org.junit.Test;


public class UserTest {

	User userTest = new User("Jonathan", "McDonagh", "M", "20", "Student");
	
	@Test
	public void testCreate(){
		assertEquals("Jonathan", userTest.firstName);
		assertEquals("McDonagh", userTest.lastName);
		assertEquals("M", userTest.gender);
		assertEquals("20", userTest.age);
		assertEquals("Student", userTest.occupation);
	}
	
	@Test
	public void testToString(){
		assertEquals("User{" + userTest.id + ", Jonathan, McDonagh, M, 20, Student}", userTest.toString());
	}
	
	@Test
	public void testEquals(){
		User user1 = new User("Jonathan", "McDonagh", "M", "20", "Student");
		User user2 = new User("Lauren", "Scally", "F", "21", "Student");
		
		assertEquals(user1, user1);
		assertEquals(user2, user2);
		assertNotEquals(user1, user2);
	}

}
