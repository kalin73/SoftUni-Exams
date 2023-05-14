package football;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FootballTeamTests {
	private FootballTeam footballTeam;

	public FootballTeamTests() {
		this.footballTeam = new FootballTeam("ManU", 1);
	}

	@Test
	public void testConstructor() {
		this.footballTeam = new FootballTeam("ManU", 1);
		String expectedTeamName = "ManU";
		int expectedVacantPositions = 1;
		

		assertEquals(expectedTeamName, this.footballTeam.getName());
		assertEquals(expectedVacantPositions, this.footballTeam.getVacantPositions());

	}
	
	@Test
	public void testGetCount() {
		Footballer footballer = new Footballer("Pesho");
		this.footballTeam.addFootballer(footballer);

		int expecetCount = 1;
		
		assertEquals(expecetCount, this.footballTeam.getCount());

	}

	@Test(expected = NullPointerException.class)
	public void testShouldThrowWhenCreatingTeamWithEmptyName() {
		this.footballTeam = new FootballTeam("", 121);
	}

	@Test(expected = NullPointerException.class)
	public void testShouldThrowWhenCreatingTeamWithNullAsName() {
		this.footballTeam = new FootballTeam(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowWhenCreatingTeamWithNoVacantPositions() {
		this.footballTeam = new FootballTeam("Man", -1);
	}

	@Test
	public void testAddingFootballers() {
		Footballer footballer = new Footballer("Pesho");
		this.footballTeam.addFootballer(footballer);

		int expecetNumberOfFootballers = 1;

		assertEquals(expecetNumberOfFootballers, footballTeam.getCount());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddingFootballerToFullTeam() {
		Footballer footballer1 = new Footballer("Pesho");
		this.footballTeam.addFootballer(footballer1);

		Footballer footballer2 = new Footballer("Ivan");
		this.footballTeam.addFootballer(footballer2);
	}

	@Test
	public void testRemovingFootballer() {
		Footballer footballer1 = new Footballer("Pesho");
		this.footballTeam.addFootballer(footballer1);

		this.footballTeam.removeFootballer("Pesho");

		int expecetNumberOfFootballers = 0;

		assertEquals(expecetNumberOfFootballers, this.footballTeam.getCount());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowIfFootballerForRemovalIsNotFound() {
		Footballer footballer1 = new Footballer("Pesho");
		this.footballTeam.addFootballer(footballer1);

		this.footballTeam.removeFootballer("Ivan");
	}

	@Test
	public void testSellingExistingFootballer() {
		Footballer footballer = new Footballer("Pesho");
		this.footballTeam.addFootballer(footballer);

		Footballer soldFootballer = this.footballTeam.footballerForSale("Pesho");

		assertTrue(soldFootballer != null);
		assertFalse(soldFootballer.isActive());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowWhenSellingNotExistingFootballer() {
		this.footballTeam.footballerForSale("Ivan");
	}

	@Test
	public void testGetStatistic() {
		String statistic = this.footballTeam.getStatistics();

		assertTrue(statistic != null);
	}

	
}
