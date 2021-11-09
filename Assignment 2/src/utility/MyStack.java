package utility;

import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E>{
	
	private MyArrayList<E> stack = new MyArrayList<>();
	
	@Override
	public void push(E toAdd) throws NullPointerException {
		if(toAdd.equals(null)) 
			throw new NullPointerException("Cannot add null element");
		
		stack.add(0, toAdd);
	}

	@Override
	public E pop() throws IndexOutOfBoundsException {
		if(stack.size() == 0)
			throw new IndexOutOfBoundsException("Stack is empty");
		
		E poppedElement = stack.get(0);
		stack.remove(0);
		return poppedElement;
		
	}

	@Override
	public E peek() throws IndexOutOfBoundsException {
		if(stack.size() == 0)
			throw new IndexOutOfBoundsException("Stack is empty");
		
		return stack.get(0);
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean isEmpty() {
		return stack.size()==0;
	}

	@Override
	public void clear() {
		stack.clear();
		
	}

	@Override
	public boolean equals(StackADT<E> that) throws NullPointerException {
		if(that.equals(null)) 
			throw new NullPointerException("Cannot find null element");
		
		Object[] a = stack.toArray();
		Object[] b = that.toArray();
		if(a.length != b.length) return false;
		for(int i = 0; i<a.length; i++)
		{
			if(a[i] != b[i])
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public int search(E toFind) throws NullPointerException {
		if(toFind.equals(null)) 
			throw new NullPointerException("Cannot find null element");
		
		for(int i = 0; i < stack.size(); i++)
		{
			if(stack.get(i).equals(toFind))
			{
				return i+1;
			}
		}
		return 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for(int i = 0; i < stack.size(); i++)
		{
			if(stack.get(i).equals(toFind))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		return stack.toArray();
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		return stack.toArray(toHold);
	}

	@Override
	public Iterator<E> iterator() {
		return stack.iterator();
	}

}
