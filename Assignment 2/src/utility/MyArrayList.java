package utility;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E>, Iterator
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
		arrayList = EMPTY_ARRAYLIST;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
		if(toAdd == null)
				throw new NullPointerException("Cannot add a null element.");
		//if index is the size, then add to the end
		if(index == size)
		{
			size++;
			arrayList = (E[]) Arrays.copyOf(this.arrayList, size, this.arrayList.getClass());
			arrayList[size-1] = toAdd;
			for(int i = 0; i < size; i++)
			{
				System.out.println(arrayList[i]);
			}
		}
		//if not then shift subsequent values and insert
		else
		{
			//copy arraylist with +1 size and increment size
			size++;
			arrayList = (E[]) Arrays.copyOf(this.arrayList, size, this.arrayList.getClass());
			for(int i = size-1; i > index; i--)
			{
				arrayList[i] = arrayList[i-1];
			}
			arrayList[index] = toAdd;
			for(int i = 0; i < size; i++)
			{
				System.out.println(arrayList[i]);
			}
		}
		if(get(index).equals(toAdd))
			return true;
		else 
			return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException 
	{
		if(toAdd == null)
		{
			throw new NullPointerException("Cannot add a null element.");
		}
		//copy arraylist with +1 size
		this.arrayList = (E[]) Arrays.copyOf(this.arrayList, size+1, this.arrayList.getClass());
		arrayList[size++] = toAdd;
		if(arrayList[size-1].equals(toAdd))
			return true;
		else return false;
	}

	@Override
	public boolean addAll(ListADT toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}
	
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
	
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return this.arrayList[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
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

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
