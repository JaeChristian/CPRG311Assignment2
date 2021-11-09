package tests;

import static org.junit.jupiter.api.Assertions.*;
import utility.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyDLLTests {
	MyDLL<String> DLL;
	@BeforeEach
	void setUp() {
		DLL = new MyDLL<>();
	}
	
	@AfterEach
	void end() {
		DLL.clear();
	}
	
	/**
	 * Test if size returns the correct size.
	 */
	@Test
	void testSize() {
		assertEquals(0, DLL.size());
	}
	
	/**
	 * Test if add with no index parameter adds to the tail
	 */
	@Test
	void testAdd() {
		assertTrue(DLL.add("one"));
	}
	
	/**
	 * Test if add with index parameter adds to appointed index.
	 */
	@Test
	void testAddByIndex() {
		addList();
		assertTrue(DLL.add(0, "two.five"));
	}
	
	@Test 
	void testAddAll() {
		MyArrayList<String> toAdd = new MyArrayList<>();
		toAdd.add("five");
		toAdd.add("six");
		toAdd.add("seven");
		addList();
		assertTrue(DLL.addAll(toAdd));
		
	}
	
	@Test 
	void removeByIndex(){
		addList();
		assertEquals("four", DLL.remove(3));
		//printList();
	}
	
	@Test 
	void removeByElement() {
		addList();
		DLL.add(1, "three");
		assertEquals("three", DLL.remove("three"));
		//printList();
	}
	
	@Test
	void testSet() {
		addList();
		assertEquals("five", DLL.set(0, "five"));
		//printList();
	}
	
	@Test
	void testEmpty() {
		assertTrue(DLL.isEmpty());
	}
	
	@Test
	void testContains() {
		addList();
		assertFalse(DLL.contains("five"));
		assertTrue(DLL.contains("one"));
	}
	
	@Test
	void testToArray() {
		addList();
		assertEquals("one", DLL.toArray()[0]);
		
	}

	@Test
	void testToHold() {
		addList();
		String[] toHold = {"two", "four", "six", "eight","ten", "twelve"};
		DLL.toArray(toHold);
		assertEquals("one", toHold[0]);
	}
	
	@Test
	void testNext()
	{
		addList();
		Iterator<String> iterator = DLL.iterator();
		iterator.next();
		assertEquals("two", iterator.next());
	}
	
	@Test
	void testHasNext()
	{
		addList();
		Iterator<String> iterator = DLL.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		assertFalse(iterator.hasNext());
	}
	
	/**
	 * Test if get returns the correct node element
	 */
	@Test
	void testGet() {
		addList();
		assertEquals("one", DLL.get(0));
	}
	
	void printList() {
		for(int i = 0; i<DLL.size();i++) {
			System.out.println(DLL.get(i));
		}
	}
	void addList() {
		DLL.add("one");
		DLL.add("two");
		DLL.add("three");
		DLL.add("four");
	}
}
