package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
		//System.out.println("List size: " + this.list.size());
	}
	/**
	 * Tests the default size of an empty arraylist
	 * (0)
	 */
	@Test
	void testDefaultSize()
	{
		assertEquals(0, this.list.size());
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
		assertTrue(this.list.add(5, "one.five"));
	}
	
	/*
	 * Tests if element can be added to the list
	 */
	@Test
	void testAdd()
	{
		assertTrue(this.list.add("one"));
	}
	
	/*
	 * Tests if all elements can be added to the list
	 */
	@Test
	void testAddAll()
	{
		MyArrayList<String> add = new MyArrayList<>();
		addList();
		add.add("one");
		add.add("two");
		add.add("57");
		assertTrue(this.list.addAll(add));
	}
	
	/**
	 * Test if next iterator works
	 */
	@Test
	void testNext()
	{
		addList();
		Iterator<String> iterator = this.list.iterator();
		iterator.next();
		assertEquals("two", iterator.next());
	}
	
	/*
	 * Tests if hasNext boolean returns false in its last iteration
	 */
	@Test
	void testHasNext()
	{
		addList();
		Iterator<String> iterator = this.list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		assertFalse(iterator.hasNext());
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
		this.list.remove(2);
		assertEquals("four", this.list.get(2));
	}
	
	@Test
	void testRemoveByElement()
	{
		addList();
		//assertEquals("three", this.list.remove("three"));
	}
	
	@Test
	void testRemoveElementShifted()
	{
		addList();
		boolean found = false;
		this.list.remove("three");
		for(int i = 0;i<this.list.size();i++)
		{
			if(this.list.get(i).equals("three")) found=true;
		}
		assertFalse(found);
	}
	
	/**
	 * Test if element at index was set
	 */
	@Test
	void testSet()
	{
		addList();
		assertEquals("twoo", this.list.set(1, "twoo"));
	}
	
	/**
	 * Tests if list contains two
	 */
	@Test
	void testContains()
	{
		String[] add = {"one", "two", "three", "four", "five"};
		for(int i = 0; i < add.length; i++)
		{
			this.list.add(add[i]);
		}
		assertTrue(this.list.contains("two"));
	}
	
	/**
	 * Test toArray with toHold parameter
	 */
	@Test
	void testToHold()
	{
		addList();
		String[] toHold = {"two", "four", "six", "eight","ten", "twelve"};
		this.list.toArray(toHold);
		assertEquals("one", toHold[0]);
	}
	
	/**
	 * Test toArray with no parameter
	 */
	@Test
	void testToArray()
	{
		String[] add = {"one", "two", "three", "four", "five"};
		addList();
		//this.list.add("fifty one");
		assertEquals("one", this.list.toArray()[0]);
		
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
