package utility;

import java.util.Arrays;
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
		head = null;
		tail = null;
		size = 0;
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
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
		
		DLLNode<E> removedNode;
		if(size==1) {
			removedNode = head;
			head = null;
			tail = null;
		} else if(index == 0 && size != 1){ //if removing head
			removedNode = head;
			head.getNext().setPrev(null);
			head = head.getNext();
		} else if(index == size-1) { //if removign tail
			removedNode = tail;
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			removedNode = getNode(index);
			removedNode.getPrev().setNext(removedNode.getNext());
			removedNode.getNext().setPrev(removedNode.getPrev());
		}
		size--;
		return removedNode.getElement();
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove.equals(null))
			throw new NullPointerException("Cannot remove null element");
		DLLNode<E> removedNode = null;
		for(int i = 0; i < size; i++) {
			if(get(i).equals(toRemove))
			{
				removedNode = getNode(i);
				remove(i);
			}
		}
		if(!removedNode.equals(null)) {
			return toRemove;
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
		if(toChange.equals(null))
			throw new NullPointerException("Cannot add null element");
		
		getNode(index).setElement(toChange);
		
		if(get(index).equals(toChange))
			return toChange;
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException, IndexOutOfBoundsException {
		if(size==0)
			throw new IndexOutOfBoundsException("list is empty");
		if(toFind.equals(null))
			throw new NullPointerException("Cannot add null element");
		
		for(int i = 0; i < size; i++) {
			if(get(i).equals(toFind))
				return true;
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		E[] a = (E[])toArray();
		
		if(toHold.length < size)
		{
			return (E[]) Arrays.copyOf(a, size, toHold.getClass());
		}
		System.arraycopy(a, 0, toHold, 0, size);
		if(toHold.length > size)
		{
			toHold[size] = null;
		}
		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] DLLArray = new Object[size];
		for(int i = 0; i < size; i++) {
			DLLArray[i] = get(i);
		}
		return DLLArray;
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
		int index = -1;
		
		@Override
		public boolean hasNext() {
			if(index<size-1)
			{
				return true;
			}
			return false;
		}

		@Override
		public E next() throws NoSuchElementException {
			if(!hasNext())
			{
				throw new NoSuchElementException("No more elements in iterator");
			}
			E nextElement = get(index+1);
			index++;
			return nextElement;
		}
		
	}
}
