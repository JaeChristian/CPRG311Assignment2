package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import utility.*;

class MyArrayListTests {
	/**
	 * Contains the ArrayList that is manipulated in each test.
	 */
	private MyArrayList<String> list;
	
	/**
	 * Instantiates a new ArrayList before each test.
	 */
	@BeforeEach
	void setUp()
	{
		this.list = new MyArrayList<String>();
	}
	
	/**
	 * Clears the ArrayList after each test.
	 */
	@AfterEach
	void end()
	{
		this.list.clear();
	}
	
	/**
	 * Test if the list size is equal to 5
	 */
	@Test
	void testSize()
	{
		addList();
		assertEquals(5, this.list.size());
	}
	
	/**
	 * Test if the list is empty
	 */
	@Test
	void testIsEmpty()
	{
		assertTrue(this.list.isEmpty());
	}
	
	/**
	 * Adds an element to the list, clears it, then tests if it is empty
	 */
	@Test
	void testClear()
	{
		this.list.add(" ");
		this.list.clear();
		assertTrue(this.list.isEmpty());
	}
	
	@Test
	void testAddByIndex()
	{
		addList();
		assertTrue(this.list.add(1, "one.five"));
	}
	
	/*
	 * Tests if element can be added to the list
	 */
	@Test
	void testAdd()
	{
		assertTrue(this.list.add(" "));
	}
	
	/*
	 * Tests if all elements can be added to the list
	 */
	@Test
	void testAddAll()
	{
		MyArrayList<String> add = new MyArrayList<>();
		add.add("one");
		add.add("two");
		assertTrue(this.list.addAll(add));
	}
	
	/**
	 * Test if next iterator works
	 */
	@Test
	void testNext()
	{
		addList();
		assertEquals("one", this.list.next());
	}
	
	/*
	 * Tests if hasNext boolean returns true
	 */
	@Test
	void testHasNext()
	{
		addList();
		this.list.next();
		assertTrue(this.list.hasNext());
	}
	
	/**
	 * Tests if get method returns "one" at index 0
	 */
	@Test
	void testGet()
	{
		addList();
		assertEquals("one", this.list.get(0));
	}
	
	/**
	 * Tests if remove method returns the removed element
	 */
	@Test
	void testRemove()
	{
		addList();
		assertEquals("two", this.list.remove(1));
	}
	
	/**
	 * Tests if the subsequent elements after the removed element shift to the left
	 */
	@Test
	void testRemovedShifted()
	{
		addList();
		assertEquals("three", this.list.remove(2));
		assertEquals("four", this.list.get(2));
	}
	
	/**
	 * Tests if previous element gets returned
	 */
	@Test
	void testReturnPrevious()
	{
		addList();
		assertEquals("two", this.list.set(1, "twoo"));
	}
	
	/**
	 * Test if element at indexwas set
	 */
	@Test
	void testSet()
	{
		addList();
		this.list.set(1, "twoo");
		assertEquals("twoo", this.list.get(1));
	}
	
	/**
	 * Tests if list contains two
	 */
	@Test
	void testContains()
	{
		addList();
		assertTrue(this.list.contains("two"));
	}
	
	/**
	 * tests if toArray with toHold parameter modifies the parameter
	 */
	@Test
	void testToHold()
	{
		addList();
		String[] toHold = {"two", "four", "six", "eight", "ten"};
		this.list.toArray(toHold);
		//list to Array has to equal the new toHold
		assertEquals(this.list.toArray(), toHold);
	}
	
	/**
	 * Test toArray with no parameter
	 */
	@Test
	void testToArray()
	{
		String[] add = {"one", "two", "three", "four", "five"};
		addList();
		assertEquals(add, this.list.toArray());
		
	}
	
	/**
	 * Adds 5 values to the list.
	 */
	private void addList()
	{
		String[] add = {"one", "two", "three", "four", "five"};
		for(int i = 0; i < add.length; i++)
		{
			this.list.add(add[i]);
		}
	}
}
