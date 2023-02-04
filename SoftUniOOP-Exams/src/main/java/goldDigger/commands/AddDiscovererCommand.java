package goldDigger.commands;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.repositories.Repository;

public class AddDiscovererCommand implements Command {
	private String kind;
	private String discovererName;
	private Repository<Discoverer> repository;

	public AddDiscovererCommand(String kind, String discovererName, Repository<Discoverer> repository) {
		this.kind = kind;
		this.discovererName = discovererName;
		this.repository = repository;
	}

	@Override
	public String execute() {
		Discoverer discoverer;

		switch (kind) {
		case "Archaeologist":
			discoverer = new Archaeologist(discovererName);
			break;

		case "Anthropologist":
			discoverer = new Anthropologist(discovererName);
			break;

		case "Geologist":
			discoverer = new Geologist(discovererName);
			break;

		default:
			throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
		}

		repository.add(discoverer);
		return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
	}
}
