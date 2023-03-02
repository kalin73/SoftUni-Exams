package christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy {
	private static final double INITIAL_STOLEN_PORTION = 250.0;

	public Stolen(String name, double price) {
		super(name, INITIAL_STOLEN_PORTION, price);
	}
}
