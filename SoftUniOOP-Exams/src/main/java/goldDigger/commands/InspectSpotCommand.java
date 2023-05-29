package goldDigger.commands;

import java.util.List;
import java.util.stream.Collectors;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.repositories.Repository;

public class InspectSpotCommand implements Command {
	private Repository<Discoverer> discoverersRepo;
	private Repository<Spot> spotsRepo;
	private String spotName;
	public static int inspections;

	public InspectSpotCommand(Repository<Discoverer> discoverers, Repository<Spot> spots, String spotName) {
		this.discoverersRepo = discoverers;
		this.spotsRepo = spots;
		this.spotName = spotName;
	}

	@Override
	public String execute() {
		List<Discoverer> suitableDiscoverers = discoverersRepo.getCollection()
				.stream()
				.filter(x -> x.getEnergy() > 45)
				.collect(Collectors.toList());
		Operation operation = new OperationImpl();

		if (suitableDiscoverers.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
		}

		Spot spot = spotsRepo.byName(spotName);
		operation.startOperation(spot, suitableDiscoverers);
		long excluded = suitableDiscoverers
				.stream()
				.filter(x -> x.getEnergy() <= 0)
				.count();
		inspections++;

		return String.format(ConstantMessages.INSPECT_SPOT, spotName, excluded);
	}

}
