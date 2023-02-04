package goldDigger.commands;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.repositories.Repository;

public class ExcludeDiscovererCommand implements Command {
	private String discovererName;
	private Repository<Discoverer> repository;

	public ExcludeDiscovererCommand(String discovererName, Repository<Discoverer> repo) {
		this.discovererName = discovererName;
		this.repository = repo;
	}

	@Override
	public String execute() {
		Discoverer discoverer = repository.byName(discovererName);
		
		if (discoverer == null) {
			throw new IllegalArgumentException(
					String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
		}
		repository.remove(discoverer);

		return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
	}
}
