package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenericQueueAsStringTest {

	private GenericsQueue genStringQueue;

	@BeforeEach
	void setup() {
		// SETUP PHASE
		genStringQueue = new GenericsQueue(3);

	}

	@Test
	@DisplayName("Testing constructor")
	public void testConstructor() {

		assertEquals(3, genStringQueue.getMaxSize());

	}

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

	@Test
	@DisplayName("Testing peek method")
	public void testPeek() {
		// String queue-----------------------------------
		assertEquals(null, genStringQueue.peek());

		genStringQueue.offer("Hund");
		assertEquals("Hund", genStringQueue.peek());
		assertEquals("Hund", genStringQueue.peek());

	}

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
