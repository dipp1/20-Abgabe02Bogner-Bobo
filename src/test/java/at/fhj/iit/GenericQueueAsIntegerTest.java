package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenericQueueAsIntegerTest {

	private GenericsQueue genIntQueue;

	@BeforeEach
	void setup() {
		// SETUP PHASE

		genIntQueue = new GenericsQueue(3);

	}

	@Test
	@DisplayName("Testing constructor")
	public void testConstructor() {

		assertEquals(3, genIntQueue.getMaxSize());

	}

	@Test
	@DisplayName("Testing offer method")
	public void testOffer() {

		assertTrue(genIntQueue.offer(1));
		assertTrue(genIntQueue.offer(2));
		assertTrue(genIntQueue.offer(3));

		assertFalse(genIntQueue.offer(4));
		assertEquals(1, genIntQueue.peek());

	}

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

	@Test
	@DisplayName("Testing remove method")
	public void testRemove() {

		genIntQueue.offer(1);

		assertEquals(1, genIntQueue.remove());

		assertThrows(NoSuchElementException.class, () -> {
			genIntQueue.remove();
		});

	}

	@Test
	@DisplayName("Testing peek method")
	public void testPeek() {

		assertEquals(null, genIntQueue.peek());

		genIntQueue.offer(1);
		assertEquals(1, genIntQueue.peek());
		assertEquals(1, genIntQueue.peek());

	}

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
