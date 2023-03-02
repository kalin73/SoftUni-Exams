package christmasPastryShop.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
	private Collection<Booth> booths;

	public BoothRepositoryImpl() {
		this.booths = new ArrayList<>();
	}

	@Override
	public Booth getByNumber(int number) {
		for (Booth booth : booths) {
			if (booth.getBoothNumber() == number) {
				return booth;
			}
		}

		return null;
	}

	@Override
	public Collection<Booth> getAll() {
		return Collections.unmodifiableCollection(booths);
	}

	@Override
	public void add(Booth entity) {
		booths.add(entity);

	}
}
