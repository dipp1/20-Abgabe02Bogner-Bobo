/**
 * @author Tiberiu-Arthur Nowotny
 */
package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenericQueueAsStringTest {

	private GenericsQueue genStringQueue;

	/**
	 * Creates the needed Objects to test the class
	 */
	@BeforeEach
	void setup() {
		// SETUP PHASE
		genStringQueue = new GenericsQueue(3);

	}

	/**
	 * Tests the constructor by calling the getmaxsize Function
	 */
	@Test
	@DisplayName("Testing constructor")
	public void testConstructor() {

		assertEquals(3, genStringQueue.getMaxSize());

	}

	/**
	 * Tests the offer method by trying to add 4 objects to a queue with size 3
	 */
	@Test
	@DisplayName("Testing offer method")
	public void testOffer() {

		// String queue-----------------------------------

		assertTrue(genStringQueue.offer("Hund"));
		assertTrue(genStringQueue.offer("Katze"));
		assertTrue(genStringQueue.offer("Maus"));

		assertFalse(genStringQueue.offer("Wolf"));
		assertEquals("Hund", genStringQueue.peek());

	}

	/**
	 * Tests the poll function by adding 3 objects and then checking if the returned
	 * value is like expected and if the old one has been removed
	 */
	@Test
	@DisplayName("Testing poll method")
	public void testPoll() {

		// String queue-----------------------------------

		genStringQueue.offer("Hund");
		genStringQueue.offer("Katze");
		genStringQueue.offer("Maus");

		assertEquals("Hund", genStringQueue.poll());
		assertEquals("Katze", genStringQueue.peek());

		assertEquals("Katze", genStringQueue.poll());
		assertEquals("Maus", genStringQueue.peek());

		assertEquals("Maus", genStringQueue.poll());
		assertEquals(null, genStringQueue.peek());

	}

	/**
	 * Tests the remove method by adding an object and then removing it. Removes
	 * once more to see of the exception gets thrown
	 * 
	 */
	@Test
	@DisplayName("Testing remove method")
	public void testRemove() {
		// String queue-----------------------------------
		genStringQueue.offer("Hund");

		assertEquals("Hund", genStringQueue.remove());

		assertThrows(NoSuchElementException.class, () -> {
			genStringQueue.remove();
		});

	}

	/**
	 * Tests the peek method by checking if it returns null for an empty queue and
	 * if it returns the right value and does not remove it.
	 */

	@Test
	@DisplayName("Testing peek method")
	public void testPeek() {
		// String queue-----------------------------------
		assertEquals(null, genStringQueue.peek());

		genStringQueue.offer("Hund");
		assertEquals("Hund", genStringQueue.peek());
		assertEquals("Hund", genStringQueue.peek());

	}

	/**
	 * Tests if an exception gets thrown by an empty queue. Also tests if the return
	 * value is the set value if the queue is not empty
	 * 
	 */
	@Test
	@DisplayName("Testing element method")
	public void testElement() {
		// String queue-----------------------------------
		assertThrows(NoSuchElementException.class, () -> {
			genStringQueue.element();
		});

		genStringQueue.offer("Hund");
		assertEquals("Hund", genStringQueue.element());

	}

}
