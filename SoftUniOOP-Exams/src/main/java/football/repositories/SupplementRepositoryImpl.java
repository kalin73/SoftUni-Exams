package football.repositories;

import java.util.ArrayList;
import java.util.Collection;

import football.entities.supplement.Supplement;

public class SupplementRepositoryImpl implements SupplementRepository {
	private Collection<Supplement> supplements;

	public SupplementRepositoryImpl() {
		this.supplements = new ArrayList<>();
	}

	@Override
	public void add(Supplement supplement) {
		this.supplements.add(supplement);

	}

	@Override
	public boolean remove(Supplement supplement) {
		return this.supplements.remove(supplement);
	}

	@Override
	public Supplement findByType(String type) {
		return this.supplements.stream().filter(x -> x.getClass().getSimpleName().equals(type)).findFirst()
				.orElse(null);
	}

}
