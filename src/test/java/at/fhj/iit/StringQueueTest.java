package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;

@DisplayName("Testing StringQueue implementation")
class StringQueueTest {

	private StringQueue testQueue;

	// TODO Write your own tests

	/**
	 * 
	 */
	@BeforeEach
	void setup() {
		// SETUP PHASE
		testQueue = new StringQueue(3);
	}

	@Test
	@DisplayName("Testing constructor")
	public void testConstructor() {

		assertEquals(3, testQueue.getMaxSize());

	}

	@Test
	@DisplayName("Testing offer method")
	public void testOffer() {

		assertTrue(testQueue.offer("Hund"));
		assertTrue(testQueue.offer("Katze"));
		assertTrue(testQueue.offer("Maus"));

		assertFalse(testQueue.offer("Wolf"));
		assertEquals("Hund", testQueue.peek());

	}

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

	@Test
	@DisplayName("Testing remove method")
	public void testRemove() {

		testQueue.offer("Hund");
//		testQueue.offer("Katze");

		assertEquals("Hund", testQueue.remove());

		assertThrows(NoSuchElementException.class, () -> {
			testQueue.remove();
		});

	}

	@Test
	@DisplayName("Testing peek method")
	public void testPeek() {

		assertEquals(null, testQueue.peek());

		testQueue.offer("Hund");
		assertEquals("Hund", testQueue.peek());
		assertEquals("Hund", testQueue.peek());

	}

	@Test
	@DisplayName("Testing element method")
	public void testElement() {

		assertThrows(NoSuchElementException.class, () -> {
			testQueue.element();
		});

		testQueue.offer("Hund");
		assertEquals("Hund", testQueue.remove());

	}

}