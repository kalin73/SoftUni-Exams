package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer {
	private static double initialEnergy = 100;

	public Geologist(String name) {
		super(name, initialEnergy);
	}

}
