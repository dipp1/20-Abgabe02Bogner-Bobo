/**
 * @author Tiberiu-Arthur Nowotny
 */
package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GenericQueueAsIntegerTest {

	private GenericsQueue genIntQueue;

	/**
	 * Creates the needed Objects to test the class
	 */
	@BeforeEach
	void setup() {
		// SETUP PHASE

		genIntQueue = new GenericsQueue(3);

	}

	/**
	 * Tests the constructor by calling the getmaxsize Function
	 */
	@Test
	@DisplayName("Testing constructor")
	public void testConstructor() {

		assertEquals(3, genIntQueue.getMaxSize());

	}

	/**
	 * Tests the offer method by trying to add 4 objects to a queue with size 3
	 */
	@Test
	@DisplayName("Testing offer method")
	public void testOffer() {

		assertTrue(genIntQueue.offer(1));
		assertTrue(genIntQueue.offer(2));
		assertTrue(genIntQueue.offer(3));

		assertFalse(genIntQueue.offer(4));
		assertEquals(1, genIntQueue.peek());

	}

	/**
	 * Tests the poll function by adding 3 objects and then checking if the returned
	 * value is like expected and if the old one has been removed
	 */
	@Test
	@DisplayName("Testing poll method")
	public void testPoll() {

		genIntQueue.offer(1);
		genIntQueue.offer(2);
		genIntQueue.offer(3);

		assertEquals(1, genIntQueue.poll());
		assertEquals(2, genIntQueue.peek());

		assertEquals(2, genIntQueue.poll());
		assertEquals(3, genIntQueue.peek());

		assertEquals(3, genIntQueue.poll());
		assertEquals(null, genIntQueue.peek());

	}

	/**
	 * Tests the remove method by adding an object and then removing it. Removes
	 * once more to see of the exception gets thrown
	 * 
	 */
	@Test
	@DisplayName("Testing remove method")
	public void testRemove() {

		genIntQueue.offer(1);

		assertEquals(1, genIntQueue.remove());

		assertThrows(NoSuchElementException.class, () -> {
			genIntQueue.remove();
		});

	}

	/**
	 * Tests the peek method by checking if it returns null for an empty queue and
	 * if it returns the right value and does not remove it.
	 */
	@Test
	@DisplayName("Testing peek method")
	public void testPeek() {

		assertEquals(null, genIntQueue.peek());

		genIntQueue.offer(1);
		assertEquals(1, genIntQueue.peek());
		assertEquals(1, genIntQueue.peek());

	}

	/**
	 * Tests if an exception gets thrown by an empty queue. Also tests if the return
	 * value is the set value if the queue is not empty
	 * 
	 */
	@Test
	@DisplayName("Testing element method")
	public void testElement() {

		assertThrows(NoSuchElementException.class, () -> {
			genIntQueue.element();
		});

		genIntQueue.offer(1);
		assertEquals(1, genIntQueue.element());

	}

}
