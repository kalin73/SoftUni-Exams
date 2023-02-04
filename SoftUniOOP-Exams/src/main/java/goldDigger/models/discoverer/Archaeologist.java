package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer{
	private static double initialEnergy = 60;

	public Archaeologist(String name) {
		super(name, initialEnergy);
	}

}
