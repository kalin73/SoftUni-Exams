package archeologicalExcavations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {

	private Excavation excavation;
	Archaeologist archaeologist1;
	Archaeologist archaeologist2;
	Archaeologist archaeologist3;

	@Before
	public void setUp() {
		archaeologist1 = new Archaeologist("Straho", 100);
		archaeologist2 = new Archaeologist("Straho", 150);
		archaeologist3 = new Archaeologist("Kalin", 50);
	}

	@Test(expected = NullPointerException.class)
	public void testShouldThrowWithEmthyName() {
		String name = "";
		excavation = new Excavation(name, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowWithNegativeCapacity() {
		excavation = new Excavation("Kalin", -1);
	}

	@Test
	public void testGetCount() {
		excavation = new Excavation("Firm", 5);

		excavation.addArchaeologist(archaeologist1);
		excavation.addArchaeologist(archaeologist3);

		int expected = 2;

		assertEquals(expected, excavation.getCount());

	}

	@Test
	public void testGetName() {
		excavation = new Excavation("Firm", 5);
		String expected = "Firm";

		assertEquals(expected, excavation.getName());

	}

	@Test
	public void testGetCapacity() {
		excavation = new Excavation("Firm", 5);
		int expected = 5;

		assertEquals(expected, excavation.getCapacity());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowIfCapacityLimitIsReached() {
		excavation = new Excavation("Firm", 1);

		excavation.addArchaeologist(archaeologist1);
		excavation.addArchaeologist(archaeologist3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowIfContainsName() {
		excavation = new Excavation("Firm", 2);
		excavation.addArchaeologist(archaeologist1);
		excavation.addArchaeologist(archaeologist2);
	}

	@Test
	public void testAddingToCollection() {
		excavation = new Excavation("Firm", 3);
		int beforeAddCount = excavation.getCount();

		excavation.addArchaeologist(archaeologist1);
		int afterAddCount = excavation.getCount();

		assertEquals(0, beforeAddCount);
		assertEquals(1, afterAddCount);

	}

	@Test
	public void testRemoveingFromCollection() {
		excavation = new Excavation("Firm", 3);
		excavation.addArchaeologist(archaeologist1);

		assertTrue(excavation.removeArchaeologist(archaeologist1.getName()));
	}
}
