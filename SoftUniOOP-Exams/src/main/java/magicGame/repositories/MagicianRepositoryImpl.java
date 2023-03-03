package magicGame.repositories;

import java.util.ArrayList;
import java.util.Collection;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.intefaces.Magician;
import magicGame.repositories.interfaces.MagicianRepository;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
	private Collection<Magician> data;

	public MagicianRepositoryImpl() {
		this.data = new ArrayList<>();
	}

	@Override
	public Collection<Magician> getData() {
		return data;
	}

	@Override
	public void addMagician(Magician magician) {
		if (magician == null) {
			throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
		}
		this.data.add(magician);
	}

	@Override
	public boolean removeMagician(Magician magician) {
		return this.data.remove(magician);
	}

	@Override
	public Magician findByUsername(String name) {
		return this.data.stream().filter(mag -> mag.getUsername().equals(name)).findFirst().orElse(null);
	}

}
