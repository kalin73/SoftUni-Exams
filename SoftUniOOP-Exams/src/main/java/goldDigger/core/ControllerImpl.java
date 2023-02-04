package goldDigger.core;

import goldDigger.commands.AddDiscovererCommand;
import goldDigger.commands.AddSpotCommand;
import goldDigger.commands.ExcludeDiscovererCommand;
import goldDigger.commands.GetStatisticsCommand;
import goldDigger.commands.InspectSpotCommand;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

public class ControllerImpl implements Controller {
	private Repository<Discoverer> discoverers;
	private Repository<Spot> spots;

	public ControllerImpl() {
		this.discoverers = new DiscovererRepository();
		this.spots = new SpotRepository();

	}

	@Override
	public String addDiscoverer(String kind, String discovererName) {
		return new AddDiscovererCommand(kind, discovererName, discoverers).execute();
	}

	@Override
	public String addSpot(String spotName, String... exhibits) {
		return new AddSpotCommand(spotName, spots, exhibits).execute();
	}

	@Override
	public String excludeDiscoverer(String discovererName) {
		return new ExcludeDiscovererCommand(discovererName, discoverers).execute();
	}

	@Override
	public String inspectSpot(String spotName) {
		return new InspectSpotCommand(discoverers, spots, spotName).execute();
	}

	@Override
	public String getStatistics() {
		return new GetStatisticsCommand(discoverers).execute();
	}
}
