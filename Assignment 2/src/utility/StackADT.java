package utility;
import utility.Iterator;

/**
 * <p>
 * The <code>StackADT</code> interface is designed to be used as a basis for all
 * the Stack data structures that will be developed for Assignment 2.
 * The implementors of this interface will be required to add all the functionality.
 * </p>
 * 
 * @param <E> The type of elements the stack holds.
 */
public interface StackADT<E> extends Iterator
{
	/**
	 * Precondition: Element toAdd != null.
	 * <p>Postcondition: Adds an element to the top of the stack.</p>
	 * @param toAdd 
	 * 			Element to be added to the stack.
	 * @return True if element is added successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the stack
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public Boolean push(E toAdd) throws NullPointerException;
	
	/**
	 * Precondition: List is not empty/null.
	 * <p>Postcondition: Removes the element at the top of the stack.</p>
	 * @return True if element is successfully removed.
	 * @throws NullPointerException
	 * 			If the element to be deleted is null
	 * 			(Stack is empty)
	 */
	public Boolean pop() throws NullPointerException;
	
	/**
	 * Precondition: List is not empty/null.
	 * <p>Postcondition: Retrieves the element at the top of the stack.</p>
	 * @return Element on the top of the list
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range.
	 * 			i.e. (index < 0)
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the stack
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public E peek() throws NullPointerException, IndexOutOfBoundsException;
	
	/**
	 * Precondition: None.
	 * <p>Postcondition: Returns the size of the stack.</p>
	 * @return Size of the stack
	 */
	public int size();
	
	/**
	 * Precondition: None.
	 * <p>Postcondition: Determines if the stack is empty or not.</p>
	 * @return True if stack is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Precondition: None.
	 * <p>Postcondition: Removes all elements from the stack.</p>
	 */
	public void clear();
	
	/**
	 * Precondition: <code>that</code> != null.
	 * <p>Postcondition: Determines if two stacks are equal.</p>
	 * @param that 
	 * 			Stack to be compared to.
	 * @return True if the two stacks are equal.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the stack
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public boolean equals(StackADT<E> that) throws NullPointerException;
	
	/**
	 * Precondition: <code>toFind != null</code>
	 * <p>Postcondition: Returns position of element <code>toFind</code>. </p>
	 * <p>Top of the stack is at position 1.</p>
	 * @param toFind
	 * 			element to be found.
	 * @return Position of specified element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the stack
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public int search(E toFind) throws NullPointerException;
	
	/**
	 * Precondition: <code>toFind != null</code>
	 * <p>Postcondition: Determines if stack contains the specified element.</p>
	 * @param toFind
	 * 			element to be found.
	 * @return True if element is found
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the stack
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public boolean contains(E toFind) throws NullPointerException;
	
	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence. Obeys the general contract of the 
	 * <code>java.util.Collection.toArray()</code> method.
	 * 
	 * @return An array containing all of the elements in this stack in proper
	 * 			sequence.
	 */
	public Object[] toArray();
	
	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the
	 * <code>java.util.Collection.toArray(Object [])</code> method.
	 * 
	 * @param copy
	 *			The array into which the elements of this list are to be
	 * 			stored. If the array is too small, a new array will be allocated.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException
	 * 			If the specified array is <code>null</code>.
	 */
	public E[] toArray(E[] copy) throws NullPointerException;
	
	/**
	 * Returns an iterator over the elements in this stack, in proper sequence.
	 * 
	 * @return An iterator over the elements in this stack, in proper sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 */
	public Iterator<E> iterator();
	
}
