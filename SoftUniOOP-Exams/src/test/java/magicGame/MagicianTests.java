package magicGame;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import magicsGame.Magic;
import magicsGame.Magician;

public class MagicianTests {
	private static final int DEFAULT_HEALTH = 55;
	private Magic magic;
	private Magician magician;

	@Before
	public void setUp() {
		this.magic = new Magic("Spell", 10);
		this.magician = new Magician("Pesho", DEFAULT_HEALTH);
	}

	@Test(expected = NullPointerException.class)
	public void testShouldThrowIfUsernameIsEmpty() {
		new Magician("", 55);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowIfHealthIsLessThan0() {
		new Magician("Pesho", -1);
	}

	@Test
	public void testShouldReturnUsername() {
		String expected = "Pesho";

		assertEquals(expected, magician.getUsername());
	}

	@Test
	public void testShouldReturnHealth() {
		int expected = 55;

		assertEquals(expected, magician.getHealth());
	}

	@Test
	public void testShouldAddMagicsToList() {
		magician.addMagic(magic);
		int expected = 1;

		assertEquals(expected, magician.getMagics().size());
	}

	@Test(expected = NullPointerException.class)
	public void testShouldThrowIfTryingToAddNullMagic() {
		Magic nullMagic = null;
		magician.addMagic(nullMagic);
	}

	@Test
	public void testShouldReturnListOfMagics() {
		magician.addMagic(magic);
		List<Magic> list = magician.getMagics();

		assertTrue(list != null);
	}

	@Test(expected = IllegalStateException.class)
	public void testShouldThrowIfDeadMagicianIsAttacked() {
		Magician deadMagician = new Magician("D", 0);

		deadMagician.takeDamage(5);

	}

	@Test
	public void testMagicianShouldLoseHealth() {
		magician.takeDamage(10);
		int expected = DEFAULT_HEALTH - 10;

		assertEquals(expected, magician.getHealth());

	}

	@Test
	public void testMagicianShouldDie() {
		magician.takeDamage(DEFAULT_HEALTH + 1);
		int expected = DEFAULT_HEALTH - DEFAULT_HEALTH;

		assertEquals(expected, magician.getHealth());
	}

	@Test
	public void testRemovingMagic() {
		magician.addMagic(magic);
		assertTrue(magician.getMagics().size() > 0);

		magician.removeMagic(magic);
		assertFalse(magician.getMagics().size() > 0);
	}

	@Test
	public void testShouldReturnMagicByName() {
		Magic newMagic = new Magic("New magic", 50);
		magician.addMagic(magic);
		magician.addMagic(newMagic);

		assertEquals(newMagic, magician.getMagic("New magic"));
	}
}
