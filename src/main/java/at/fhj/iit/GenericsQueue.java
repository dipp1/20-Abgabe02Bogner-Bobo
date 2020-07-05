package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericsQueue<YourClass> {

	private List<YourClass> elements = new ArrayList<YourClass>();
	private int maxSize;

	public GenericsQueue(int maxsize) {
		maxSize = maxsize;
	}

	public boolean offer(YourClass obj) { // Fixed the return

		if (elements.size() != maxSize) {
			elements.add(obj);
			return true;
		} else {

			return false;

		}

	}

	public YourClass poll() { // fixed the size bug
		YourClass element = peek();

		if (elements.size() > 0) {
			elements.remove(0);
		}

		return element;
	}

	public YourClass remove() { // fixed the remove function
		YourClass element = poll();
		
		if (element == null) {
			throw new NoSuchElementException("there's no element any more");
		}

		return element;

	}

	public YourClass peek() {
		YourClass element;
		if (elements.size() > 0) {
			element = elements.get(0);
		} else {
			element = null;
		}

		return element;
	}

	public YourClass element() {
		YourClass element = peek();

		if (element == null) {
			throw new NoSuchElementException("there's no element any more");
		}

		return element;
	}

	public int getMaxSize() {
		return maxSize;
	}

}
