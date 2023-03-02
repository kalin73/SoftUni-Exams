package toyStore;

import static org.junit.Assert.*;

import java.util.Map;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;

public class ToyStoryTest {
	private ToyStore toyStore;

	@Before
	public void setUp() {
		this.toyStore = new ToyStore();
	}

	@Test
	public void testToyStoreConstructor() {
		boolean testResult = toyStore.getToyShelf().size() > 0;
		assertTrue(testResult);
	}

	@Test
	public void testGetToyShelfShouldReturnMap() {
		Map<String, Toy> map = toyStore.getToyShelf();
		boolean result = map != null;
		assertTrue(result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowIfShelfDoesntExist() throws OperationNotSupportedException, IllegalArgumentException {
		toyStore.addToy("Z", new Toy("Santa", "55"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowIfShelfIsFull() throws OperationNotSupportedException, IllegalArgumentException {
		Toy toy = new Toy("Santa", "55");
		Toy newToy = new Toy("Santa", "44");

		toyStore.addToy("A", toy);
		toyStore.addToy("A", newToy);

	}

	@Test(expected = OperationNotSupportedException.class)
	public void testShouldThrowIfSheContainsToy() throws OperationNotSupportedException, IllegalArgumentException {
		Toy toy = new Toy("Santa", "55");

		toyStore.addToy("A", toy);
		toyStore.addToy("B", toy);

	}

	@Test
	public void testAddingToy() throws OperationNotSupportedException, IllegalArgumentException {
		Toy toy = new Toy("Santa", "55");
		String successfullyAdded = null;

		successfullyAdded = toyStore.addToy("A", toy);

		assertTrue(successfullyAdded != null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveShouldThrowIfShelfDoesntExist()
			throws OperationNotSupportedException, IllegalArgumentException {
		Toy toy = new Toy("Santa", "55");
		toyStore.addToy("A", toy);

		toyStore.removeToy("Z", toy);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveShouldThrowIfToyDoesntExist()
			throws OperationNotSupportedException, IllegalArgumentException {
		Toy toy = new Toy("Santa", "55");
		toyStore.addToy("A", toy);

		Toy newToy = new Toy("Santa", "33");

		toyStore.removeToy("A", newToy);
	}

	@Test
	public void testSouldRemoveSuccessfully() throws OperationNotSupportedException, IllegalArgumentException {
		Toy toy = new Toy("Santa", "55");
		toyStore.addToy("A", toy);

		String resultString = null;

		resultString = toyStore.removeToy("A", toy);
		Toy emptyShelf = toyStore.getToyShelf().get("A");

		assertTrue(resultString != null);
		assertEquals(null, emptyShelf);

	}
}