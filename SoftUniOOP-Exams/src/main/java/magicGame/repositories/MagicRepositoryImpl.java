package magicGame.repositories;

import java.util.ArrayList;
import java.util.Collection;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.interfaces.Magic;
import magicGame.repositories.interfaces.MagicRepository;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
	private Collection<Magic> data;

	public MagicRepositoryImpl() {
		this.data = new ArrayList<>();
	}

	@Override
	public Collection<Magic> getData() {
		return data;
	}

	@Override
	public void addMagic(Magic magic) {
		if (magic == null) {
			throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
		}
		this.data.add(magic);
	}

	@Override
	public boolean removeMagic(Magic model) {
		return this.data.remove(model);
	}

	@Override
	public Magic findByName(String name) {
		return this.data.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
	}

}
