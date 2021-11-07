package utility;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * <p>
 * The <code>QueueADT</code> interface is designed to be used as a basis for all
 * the Queue data structures that will be developed for Assignment 2.
 * The implementors of this interface will be required to add all the functionality.
 * </p>
 * 
 * @param <E> The type of elements the stack holds.
 */
public interface QueueADT<E> extends Serializable
{
	/**
	 * <p>Precondition: <code>toAdd != null</code></p>
	 * <p>Postcondition: Adds an element to the end of the queue.</p>
	 * @param toAdd
	 * 			Element to be added.
	 * @return True if enqueue is successful.
	 * @throws NullPointerException
	 * 			If <code>toAdd == null</code>
	 */
	public Boolean enqueue(E toAdd) throws NullPointerException;
	
	/**
	 * Precondition: List is not empty/null.
	 * Postcondition: Removes the first element from a queue.
	 * @return	Dequeued element.
	 * @throws NoSuchElementException
	 * 			If element to be removed is null
	 * 			(Queue is empty)
	 */
	public E dequeue() throws NoSuchElementException;
	
	/**
	 * Precondition: List is not empty/null
	 * Postcondition: Retrieves the first element from a queue
	 * @return First element in a queue
	 * @throws NoSuchElementException
	 * 			If retrieved element is null
	 * 			(Queue is empty)
	 */
	public E peek() throws NoSuchElementException;
	
	/**
	 * Precondition: None.
	 * <p>Postcondition: Returns the size of the queue.</p>
	 * @return Size of the queue
	 */
	public int size();
	
	/**
	 * Precondition: None.
	 * <p>Postcondition: Determines if the queue is empty or not.</p>
	 * @return True if queue is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Precondition: None.
	 * <p>Postcondition: Removes all elements from the queue.</p>
	 */
	public void dequeueAll();
	
	/**
	 * Precondition: <code>that</code> != null.
	 * <p>Postcondition: Determines if two queues are equal.</p>
	 * @param that 
	 * 			Queue to be compared to.
	 * @return True if the two stacks are equal.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the stack
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public boolean equals(QueueADT<E> that) throws NullPointerException;
	
	/**
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence. Obeys the general contract of the 
	 * <code>java.util.Collection.toArray()</code> method.
	 * 
	 * @return An array containing all of the elements in this queue in proper
	 * 			sequence.
	 */
	public Object[] toArray();
	
	/**
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the
	 * <code>java.util.Collection.toArray(Object [])</code> method.
	 * 
	 * @param copy
	 *			The array into which the elements of this queue are to be
	 * 			stored. If it is not big enough, a new array will be allocated.
	 * @return An array containing the elements of this queue.
	 * @throws NullPointerException
	 * 			If the specified array is <code>null</code>.
	 */
	public E[] toArray(E[] toHold) throws NullPointerException;
	
	/**
	 * Precondition: Queue object must be created.
	 * <p>Postcondition:Returns true if the number of items in the queue equals the length.</p>
	 * This operation is only implement when a fixed length queue is required.
	 * @return <code>true</code> if queue is at capacity.
	 */
	public boolean isFull();
	
	/**
	 * Returns an iterator over the elements in this queue, in proper sequence.
	 * 
	 * @return An iterator over the elements in this queue, in proper sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 */
	public Iterator<E> iterator();
}
