//Author - Jonathan McDonagh / June 2018
package models;

import static org.junit.Assert.*;

import org.junit.Test;


public class RatingTest {

		Rating rating0 = new Rating(0, 0, 0);
		Rating rating1 = new Rating(1, 1, 1);
		
		@Test
		public void testCreate(){
			assertEquals(0, rating0.userId);
			assertNotEquals(1, rating0.userId);
			assertEquals(0, rating0.bookId);
			assertNotEquals(1, rating0.bookId);
			assertNotEquals(1, rating0.rating);				
		}
		
		@Test
		public void testEquals(){
			assertEquals(rating0, rating0);
			assertEquals(rating1, rating1);
			assertNotEquals(rating0, rating1);
		}
		
}


