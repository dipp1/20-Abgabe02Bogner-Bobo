/**
 * This class represents a String Queue
 * @author Tiberiu-Arthur Nowotny
 */
package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StringQueue implements IQueue {

	private List<String> elements = new ArrayList<String>();
	private int maxSize;

	/**
	 * Queue default constructor
	 * 
	 * @param maxsize is the maximal size of the queue
	 */
	public StringQueue(int maxsize) {
		maxSize = maxsize;
	}

	/**
	 * Adds Objects in the Queue
	 * 
	 * @param obj is the String object you want to put in the queue
	 * @return either true if it is successfully added or false if the queue is full
	 */
	@Override
	public boolean offer(String obj) { // Fixed the return

		if (elements.size() != maxSize) {
			elements.add(obj);
			return true;
		} else {

			return false;

		}

	}

	/**
	 * Returns the head (first) element and also deletes it. That is, we cannot get
	 * it again. If no element exists (when queue is empty), the method returns
	 * null.
	 * 
	 * @return either the object or null
	 */
	@Override
	public String poll() { // fixed the size bug
		String element = peek();

		if (elements.size() > 0) {
			elements.remove(0);
		}

		return element;
	}

	/**
	 * It also returns and deletes the head element like poll(), but with a small
	 * difference. This method throws NoSuchElementException if the queue is empty.
	 *
	 * @return either the element which has a value or is null
	 */
	@Override
	public String remove() { // fixed the remove function
		String element = poll();

		if (element == null) {
			throw new NoSuchElementException("there's no element any more");
		}

		return element;

	}

	/**
	 * Returns the head element but it does not delete it. That is, we can get it
	 * again. Returns null when the queue is empty.
	 *
	 * @return either the element or null if empty
	 */
	@Override
	public String peek() {
		String element;
		if (elements.size() > 0) {
			element = elements.get(0);
		} else {
			element = null;
		}

		return element;
	}

	/**
	 * It works similar to peek() but with a small difference (returns but does not
	 * delete the element). It throws NoSuchElementException when the queue is
	 * empty.
	 *
	 * @return either the element or null
	 */
	@Override
	public String element() {
		String element = peek();

		if (element == null) {
			throw new NoSuchElementException("there's no element any more");
		}

		return element;
	}

	/**
	 * Returns the max size of the queue
	 * 
	 * @return the max size of the queue
	 */
	public int getMaxSize() {
		return maxSize;
	}

}