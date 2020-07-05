/**
 * @author Tiberiu-Arthur Nowotny
 */
package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;

@DisplayName("Testing StringQueue implementation")
public class StringQueueTest {

	private StringQueue testQueue;

	// TODO Write your own tests

	/**
	 * Creates the needed Objects to test the class
	 */
	@BeforeEach
	void setup() {
		// SETUP PHASE
		testQueue = new StringQueue(3);
	}

	/**
	 * Tests the constructor by calling the getmaxsize Function
	 */
	@Test
	@DisplayName("Testing constructor")
	public void testConstructor() {

		assertEquals(3, testQueue.getMaxSize());

	}

	/**
	 * Tests the offer method by trying to add 4 objects to a queue with size 3
	 */
	@Test
	@DisplayName("Testing offer method")
	public void testOffer() {

		assertTrue(testQueue.offer("Hund"));
		assertTrue(testQueue.offer("Katze"));
		assertTrue(testQueue.offer("Maus"));

		assertFalse(testQueue.offer("Wolf"));
		assertEquals("Hund", testQueue.peek());

	}

	/**
	 * Tests the poll function by adding 3 objects and then checking if the returned
	 * value is like expected and if the old one has been removed
	 */
	@Test
	@DisplayName("Testing poll method")
	public void testPoll() {

		testQueue.offer("Hund");
		testQueue.offer("Katze");
		testQueue.offer("Maus");

		assertEquals("Hund", testQueue.poll());
		assertEquals("Katze", testQueue.peek());

		assertEquals("Katze", testQueue.poll());
		assertEquals("Maus", testQueue.peek());

		assertEquals("Maus", testQueue.poll());
		assertEquals(null, testQueue.peek());

	}

	/**
	 * Tests the remove method by adding an object and then removing it. Removes
	 * once more to see of the exception gets thrown
	 * 
	 */
	@Test
	@DisplayName("Testing remove method")
	public void testRemove() {

		testQueue.offer("Hund");

		assertEquals("Hund", testQueue.remove());

		assertThrows(NoSuchElementException.class, () -> {
			testQueue.remove();
		});

	}

	/**
	 * Tests the peek method by checking if it returns null for an empty queue and
	 * if it returns the right value and does not remove it.
	 */

	@Test
	@DisplayName("Testing peek method")
	public void testPeek() {

		assertEquals(null, testQueue.peek());

		testQueue.offer("Hund");
		assertEquals("Hund", testQueue.peek());
		assertEquals("Hund", testQueue.peek());

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
			testQueue.element();
		});

		testQueue.offer("Hund");
		assertEquals("Hund", testQueue.element());

	}

}
