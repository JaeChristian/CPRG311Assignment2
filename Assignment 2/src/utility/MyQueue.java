package utility;

import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<E>{
	
	private MyDLL<E> queue;
	private boolean isFixed = false;
	private int limit;
	
	public MyQueue() {
		queue = new MyDLL<>();
	}
	
	public MyQueue(int limit) {
		queue = new MyDLL<>();
		isFixed = true;
		this.limit = limit;
	}
	@Override
	public void enqueue(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(isFixed && queue.size()==limit) {
			throw new IndexOutOfBoundsException("Queue is of fixed length. Maximum length reached.");
		} else {
			queue.add(toAdd);
		}
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		return queue.remove(0);
	}

	@Override
	public E peek() throws NoSuchElementException {
		return queue.get(0);
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void dequeueAll() {
		queue.clear();
	}

	@Override
	public boolean equals(QueueADT<E> that) throws NullPointerException {
		if(that == null) 
			throw new NullPointerException("Cannot find null element");
		
		Object[] a = queue.toArray();
		Object[] b = that.toArray();
		for(int i = 0; i < a.length;i++) {
			if(!a[i].equals(b[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		return queue.toArray(toHold);
	}

	@Override
	public boolean isFull() {
		if(isFixed && queue.size()==limit) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return queue.iterator();
	}
	
	
}
