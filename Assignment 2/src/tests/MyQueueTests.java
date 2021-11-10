package tests;
import utility.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTests {
	MyQueue<String> queue;
	
	@BeforeEach
	void setUp() {
		queue = new MyQueue<>();
	}
	
	@AfterEach
	void end() {
		queue.dequeueAll();
	}
	
	@Test
	void testEnqueue() {
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		assertEquals("one", queue.peek());
	}
	
	@Test
	void testPrintDequeue() {
		fillQueue();
		int size = queue.size();
		for(int i = 0; i<size;i++) {
			//System.out.println(queue.dequeue());
		}
	}
	
	@Test
	void testPeek() {
		fillQueue();
		assertEquals("one", queue.peek());
	}
	
	@Test
	void testSize() {
		fillQueue();
		assertEquals(4, queue.size());
	}
	
	@Test
	void testDequeue() {
		fillQueue();
		assertEquals("one", queue.dequeue());
	}
	
	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
	}
	
	@Test 
	void testDequeueAll() {
		fillQueue();
		queue.dequeueAll();
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void testEquals() {
		MyQueue<String> queueb = new MyQueue<>();
		queue.enqueue("one");
		queue.enqueue("two");
		queueb.enqueue("one");
		queueb.enqueue("two");
		
		assertTrue(queue.equals(queueb));
		queueb.dequeue();
		assertFalse(queue.equals(queueb));
	}
	
	@Test
	 void testEnqueueLimit() {
		queue = new MyQueue<>(4);
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		queue.enqueue("four");
		assertTrue(queue.isFull());
	}
	@Test
	void testToHold() {
		String[] toHold = {"two", "four", "six", "eight", "ten"};
		fillQueue();
		queue.toArray(toHold);
		assertTrue(toHold[0].equals("one"));
		
	}
	
	@Test
	void testIterator() {
		fillQueue();
		Iterator<String> iterator = queue.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		assertEquals("four", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	void fillQueue() {
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		queue.enqueue("four");
	}
}
