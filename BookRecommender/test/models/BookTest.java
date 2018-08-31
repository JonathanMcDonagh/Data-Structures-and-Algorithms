//Author - Jonathan McDonagh June 2018
package models;

import static org.junit.Assert.*;
import org.junit.Test;

public class BookTest {

	Book test = new Book("ManagingOneself", "2006", "PeterDrucker");
	
	@Test
	public void testCreate(){
		assertEquals("ManagingOneself", test.title);
		assertEquals("2006", test.year);
	}
	
	@Test
	public void testToString(){
		assertEquals("Book{" + test.id + ", ManagingOneself, 2006, PeterDrucker}", test.toString());
	}
}
