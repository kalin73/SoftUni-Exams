package goldDigger.core;

import java.util.List;
import java.util.stream.Collectors;

import goldDigger.commands.AddDiscovererCommand;
import goldDigger.commands.AddSpotCommand;
import goldDigger.commands.ExcludeDiscovererCommand;
import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

public class ControllerImpl implements Controller {
	private Repository<Discoverer> discoverers;
	private Repository<Spot> spots;
	private int spotCount;

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
		List<Discoverer> discoverers = this.discoverers.getCollection()
				.stream()
				.filter(d -> d.getEnergy() > 45)
				.collect(Collectors.toList());
		
		if (discoverers.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
		}
		
		Spot spot = this.spots.byName(spotName);
		Operation operation = new OperationImpl();
		
		operation.startOperation(spot, discoverers);
		long excluded = discoverers.stream().filter(d -> d.getEnergy() == 0).count();
		this.spotCount++;

		return String.format(ConstantMessages.INSPECT_SPOT, spotName, excluded);
	}

	@Override
	public String getStatistics() {
		String exhibits = "";
		StringBuilder result = new StringBuilder();
		
		result.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, this.spotCount));
		result.append(System.lineSeparator());
		result.append(ConstantMessages.FINAL_DISCOVERER_INFO);
		result.append(System.lineSeparator());

		for (Discoverer discoverer : discoverers.getCollection()) {
			result.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, discoverer.getName()));
			result.append(System.lineSeparator());
			result.append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()));
			result.append(System.lineSeparator());

			if (discoverer.getMuseum().getExhibits().isEmpty()) {
				exhibits = "None";

			} else {
				exhibits = discoverer.getMuseum()
						.getExhibits()
						.stream()
						.collect(Collectors.joining(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER));
			}
			result.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, exhibits));
			result.append(System.lineSeparator());
		}

		return result.toString().trim();
	}
}
