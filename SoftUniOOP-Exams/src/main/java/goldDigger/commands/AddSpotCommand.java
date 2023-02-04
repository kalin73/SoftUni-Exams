package goldDigger.commands;

import goldDigger.common.ConstantMessages;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.Repository;

public class AddSpotCommand implements Command {
	private String spotName;
	private String[] exhibits;
	private Repository<Spot> repository;

	public AddSpotCommand(String spotName, Repository<Spot> repo, String... exhibits) {
		this.spotName = spotName;
		this.exhibits = exhibits;
		this.repository = repo;
	}

	@Override
	public String execute() {
		Spot spot = new SpotImpl(spotName);
		for (String exhibit : exhibits) {
			spot.getExhibits().add(exhibit);
		}
		repository.add(spot);
		return String.format(ConstantMessages.SPOT_ADDED, spotName);
	}

}
