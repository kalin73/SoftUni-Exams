package christmasPastryShop.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
	private Collection<Delicacy> delicacies;

	public DelicacyRepositoryImpl() {
		this.delicacies = new ArrayList<>();
	}

	@Override
	public Delicacy getByName(String name) {
		for (Delicacy delicacy : delicacies) {
			if (delicacy.getName().equals(name)) {
				return delicacy;
			}
		}
		return null;
	}

	@Override
	public Collection<Delicacy> getAll() {
		return Collections.unmodifiableCollection(delicacies);
	}

	@Override
	public void add(Delicacy entity) {
		delicacies.add(entity);

	}

}
