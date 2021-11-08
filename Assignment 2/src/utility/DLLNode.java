package utility;

public class DLLNode<E> {
	private E element;
	private DLLNode<E> prev;
	private DLLNode<E> next;
	
	/**
	 * Preconditions: An element for the node.
	 * <p>Postconditions: Node constructor with no references to prev or next.</p>
	 * @param elem
	 * 			the element that the node holds
	 */
	public DLLNode(E elem) {
		this.prev = null;
		this.next = null;
		this.element = elem;
	}
	
	/**
	 * Preconditions: An element, previous node, and next node.
	 * <p>Postconditions: Node constructor with references to the previous and next node.</p>
	 * @param elem
	 * 			the element that the node holds.
	 * @param prev
	 * 			the link to the previous node.
	 * @param next
	 * 			the link to the next node.
	 */
	public DLLNode(E elem, DLLNode<E> prev, DLLNode<E> next) {
		this.element = elem;
		this.prev = prev;
		this.next = next;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Returns the data of the node.</p>
	 * @return element inside the node.
	 * @throws NullPointerException
	 * 				if element is null.
	 */
	public E getElement() throws NullPointerException{
		if(element.equals(null))
			throw new NullPointerException("Cannot get null element");
		return element;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Returns the next node.</p>
	 * @return next node.
	 * @throws NullPointerException
	 * 				if next node is null.
	 */
	public DLLNode getNext() throws NullPointerException{
		if(next.equals(null)) 
			throw new NullPointerException("Cannot get null node");
		return next;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Returns the previous node.</p>
	 * @return previous node.
	 * @throws NullPointerException
	 * 				if next node is null.
	 */
	public DLLNode getPrev() throws NullPointerException{
		if(prev.equals(null))
			throw new NullPointerException("Cannot get null node");
		return prev;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Sets the next node.</p>
	 * @param next
	 * 			the new next node.
	 */
	public void setNext(DLLNode next) {
		this.next = next;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Sets the next node.</p>
	 * @param prev
	 * 			the new previous node.
	 */
	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
	
	/**
	 * Preconditions: Node object must be created.
	 * <p>Postconditions: Sets a new element.</p>
	 * @param prev
	 * 			the new previous node.
	 */
	public void setElement(E element) {
		this.element = element;
	}
}
