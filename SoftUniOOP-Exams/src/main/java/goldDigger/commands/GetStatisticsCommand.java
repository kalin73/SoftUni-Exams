package goldDigger.commands;

import java.util.stream.Collectors;

import goldDigger.common.ConstantMessages;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.repositories.Repository;

public class GetStatisticsCommand implements Command {

	private Repository<Discoverer> discoverers;
	private StringBuilder result;

	public GetStatisticsCommand(Repository<Discoverer> discoverers) {
		this.discoverers = discoverers;
		result = new StringBuilder();
	}

	@Override
	public String execute() {
		int inspections = InspectSpotCommand.inspections;
		String exhibits = "";

		result.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, inspections));
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
