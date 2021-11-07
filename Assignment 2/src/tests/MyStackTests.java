package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utility.*;

class MyStackTests {
	/**
	 * Initializes the stack object variable
	 */
	private MyStack<String> stack;
	
	/**
	 * Instantiates the stack object before each test.
	 */
	@BeforeEach
	void setUp() 
	{
		this.stack = new MyStack<String>();
	}
	
	/**
	 * Clears the stack after each test is done.
	 */
	@AfterEach
	void end()
	{
		this.stack.clear();
	}
	
	/**
	 * Test pushing an element to the stack
	 */
	@Test
	void testPush()
	{
		stack.push("one");
		assertEquals("one", stack.peek());
	}
	
	/**
	 * Test if popping an element returns the popped element
	 */
	@Test
	void testPop()
	{
		addToStack();
		assertEquals("four", stack.pop());
	}
	
	/**
	 * Test if peek element returns the last element
	 */
	@Test
	void testPeek()
	{
		stack.push("one");
		stack.push("two");
		assertEquals("two", stack.peek());
	}
	
	/**
	 * Adds four elements to the stack and tests if size method returns the correct size.
	 */
	@Test
	void testSize()
	{
		addToStack();
		assertEquals(4, stack.size());
	}
	
	/**
	 * Tests if newly instantiated stack is empty
	 */
	@Test
	void testIsEmpty()
	{
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * Adds values to stack, clears it, then tests if it is empty.
	 */
	@Test
	void testClear()
	{
		addToStack();
		stack.clear();
		assertTrue(stack.isEmpty());
	}
	/**
	 * Creates another stack, pushes the same values to both stacks, then checks if they are equal.
	 */
	@Test
	void testEquals()
	{
		MyStack<String> stackb = new MyStack<>();
		stack.push("one");
		stack.push("two");
		stackb.push("one");
		stackb.push("two");
		
		assertTrue(stack.equals(stackb));
	}
	
	/**
	 * Tests if search returns correct int position.
	 */
	@Test
	void testSearch()
	{
		addToStack();
		assertEquals(4, stack.search("one"));
	}
	
	/**
	 * Tests if contains method correctly determines if one 
	 * is in the stack.
	 */
	@Test
	void testContains()
	{
		addToStack();
		assertTrue(stack.contains("one"));
	}
	
	/**
	 * Tests if toArray has the correct elements in the correct order.
	 */
	@Test
	void testToArray()
	{
		addToStack();
		assertEquals("four", stack.toArray()[0]);
	}
	
	/**
	 * Tests if toArray passes elements to toHold.
	 */
	@Test
	void testToHold()
	{
		addToStack();
		String[] toHold = {"two", "four", "six", "eight","ten", "twelve"};
		stack.toArray(toHold);
		assertEquals("four", toHold[0]);
	}
	
	/**
	 * Tests if iterator returns the next element
	 */
	@Test
	void textNext()
	{
		addToStack();
		Iterator<String> iterator = stack.iterator();
		iterator.next();
		assertEquals("three", iterator.next());
	}
	
	/**
	 * Tests if iterator returns false on the last element
	 */
	@Test
	void testHasNext()
	{
		addToStack();
		Iterator<String> iterator = stack.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		assertFalse(iterator.hasNext());
		
	}
	
	/**
	 * Adds four elements to the stack.
	 */
	void addToStack()
	{
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
	}
}
