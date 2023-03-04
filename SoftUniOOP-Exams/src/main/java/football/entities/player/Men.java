package football.entities.player;

public class Men extends BasePlayer {
	private static final double INITIAL_KILOGRAMS = 85.50;
	private static final int STRENGTH_INCREASE = 145;

	public Men(String name, String nationality, int strength) {
		super(name, nationality, INITIAL_KILOGRAMS, strength);
	}

	@Override
	public void stimulation() {
		this.strength += STRENGTH_INCREASE;

	}

}
