package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import utility.*;

class MyArrayListTests {

	private ListADT list;
	
	@BeforeEach
	void setUp() 
	{
		this.list = new MyArrayList();
	}
	
	@AfterEach
	void end()
	{
		this.list.clear();
	}
	
	@Test
	void testSize()
	{
		assertEquals(5, this.list.size());
	}
	
	@Test
	void testIsEmpty()
	{
		assertTrue(this.list.isEmpty());
	}

}
