package utility;

import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E>
{
	//private static final int DEFAULT_SIZE = 10;
	private final E[] EMPTY_ARRAYLIST = (E[]) new Object[0];
	private E[] arrayList;
	private int size;
	/**
	 * Constructs an empty array list
	 */
	public MyArrayList()
	{
		this.arrayList = EMPTY_ARRAYLIST;
		this.size = arrayList.length;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	@Override
	public void clear() {
		for(int i = 0; i < size; i++) {
			arrayList[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
		if(toAdd.equals(null))
				throw new NullPointerException("Cannot add a null element.");
		//if index is the size, then add to the end
		if(index == size)
		{
			size++;
			arrayList = copyArray(this.arrayList, size);
			arrayList[size-1] = toAdd;
			/*for(int i = 0; i < size; i++)
			{
				System.out.println(arrayList[i]);
			}*/
		}
		//if not then shift subsequent values and insert
		else
		{
			//copy arraylist with +1 size and increment size
			size++;
			arrayList = copyArray(this.arrayList, size);
			for(int i = size-1; i > index; i--)
			{
				arrayList[i] = arrayList[i-1];
			}
			arrayList[index] = toAdd;
			/*for(int i = 0; i < size; i++)
			{
				System.out.println(arrayList[i]);
			}*/
		}
		if(get(index).equals(toAdd))
			return true;
		else 
			return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException 
	{
		if(toAdd.equals(null))
		{
			throw new NullPointerException("Cannot add a null element.");
		}
		//copy arraylist with +1 size
		this.arrayList = copyArray(this.arrayList, size+1);
		arrayList[size++] = toAdd;
		if(arrayList[size-1].equals(toAdd))
			return true;
		else return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException 
	{
		if(toAdd.equals(null))
		{
			throw new NullPointerException("Cannot add a null List");
		}
		Object[] toAddArr = toAdd.toArray();
		int toAddLength = toAddArr.length;
		for(int i = 0; i<toAddLength;i++)
		{
			this.arrayList = copyArray(this.arrayList, size+1);
			arrayList[size++] = (E)toAddArr[i];
		}
		if(toAddArr[toAddLength-1].equals(arrayList[size-1])) {
			return true;
		}
		return false;
	}
	
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("Index must be between 0 and "+ size);
		}
		return this.arrayList[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
		E removedElement = arrayList[index];
		//if index is the end of the array, then remove
		if(index == size-1)
		{
			size--;
			arrayList = copyArray(this.arrayList, size);
		}
		//if not then shift subsequent values and insert
		else
		{
			//shift all values to the left
			for(int i = index; i<size-1;i++)
			{
				arrayList[i] = arrayList[i+1];
			}
			
			//copy arraylist with -1 size and increment size
			size--;
			arrayList = copyArray(this.arrayList, size);
		}
		return removedElement;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove.equals(null))
		{
			throw new NullPointerException("Cannot remove null value");
		}
		int count = 0;
		for(int i = 0; i<size;i++)
		{
			if(arrayList[i].equals(toRemove))
			{
				remove(i);
				count++;
				i=0;
			}
		}
		return toRemove;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size) 
		{
			throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
		}
		if(toChange.equals(null))
		{
			throw new NullPointerException("Cannot set element to null");
		}
		this.arrayList[index] = toChange;
		return this.arrayList[index];
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for(int i = 0; i < this.arrayList.length;i++)
		{
			if(this.arrayList[i].equals(toFind)) 
			{
				//System.out.println(this.arrayList[i]);
				return true;
			}
		}
		System.out.println("Not found");
		return false;
	}
	
	//This method does not work if toHold's length is smaller than the DLL size.
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		
		if(toHold.length == size) {
			for(int i = 0; i < size; i++) {
				toHold[i] = arrayList[i];
			}
		} else if(toHold.length > size) {
			for(int i = 0; i<size;i++) {
				toHold[i] = arrayList[i];
			}
			toHold[size] = null;
		}
		return toHold;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new iterate();
	}
	
	@Override
	public Object[] toArray() {
		return this.arrayList;
	}
	
	private E[] copyArray(E[] toCopy, int length) {
		E[] copiedArray = (E[]) new Object[length];
		if(length < toCopy.length) {
			for(int i = 0; i < length; i++) {
				copiedArray[i] = toCopy[i];
			}
		} else {
			for(int i = 0; i < toCopy.length; i++) {
				copiedArray[i] = toCopy[i];
			}
		}
		return copiedArray;
	}
	
	private class iterate implements Iterator<E>{
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
			E nextElement = arrayList[index+1];
			index++;
			return nextElement;
		}
	}
}
