package foootball.entities.player;

public class Women extends BasePlayer {
	private static final double INITIAL_KILOGRAMS = 60;
	private static final int STRENGTH_INCREASE = 115;

	public Women(String name, String nationality, int strength) {
		super(name, nationality, INITIAL_KILOGRAMS, strength);
	}

	@Override
	public void stimulation() {
		this.strength += STRENGTH_INCREASE;
	}
}
