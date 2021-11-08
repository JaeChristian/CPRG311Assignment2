package utility;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
	
	private DLLNode<E> head;
	private DLLNode<E> tail;
	private int size;
	
	/**
	 * Constructor to initialize a new DLL
	 */
	public MyDLL() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
		if(toAdd.equals(null))
			throw new NullPointerException("Cannot add null element");
		
		DLLNode<E> currNode = getNode(index);
		DLLNode<E> newNode = new DLLNode<>(toAdd);
		
		if(index == 0) {
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		else {
			currNode.getPrev().setNext(newNode);
			newNode.setPrev(currNode.getPrev());
			currNode.setPrev(newNode);
			newNode.setNext(currNode);
		}
		size++;
		if(get(index).equals(toAdd))
			return true;
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd.equals(null))
			throw new NullPointerException("Cannot add null value");
		DLLNode<E> newNode = new DLLNode(toAdd);
		//if empty list, set new node to tail and head
		if(size==0) {
			head = newNode;
			tail = newNode;
		}
		//if it isn't, set new node to the tail
		else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		//increase size of the list
		size++;
		
		if(newNode.getElement().equals(toAdd)) 
			return true;
		return false;
	}
	
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		Object[] toAddArr = toAdd.toArray();
		int toAddLength = toAddArr.length;
		for(int i = 0; i < toAddLength; i++)
		{
			add((E)toAddArr[i]);
		}
		
		if(tail.getElement().equals(toAddArr[toAddLength-1]))
			return true;
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		DLLNode<E> currNode = head;
		for(int i = 0; i < index; i++)
		{
			currNode = currNode.getNext();
		}
		return currNode.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		//	TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DLLNode getNode(int index) {
		DLLNode<E> currNode = head;
		for(int i = 0; i < index; i++)
		{
			currNode = currNode.getNext();
		}
		return currNode;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new iterate();
	}
	
	private class iterate implements Iterator<E> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() throws NoSuchElementException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
