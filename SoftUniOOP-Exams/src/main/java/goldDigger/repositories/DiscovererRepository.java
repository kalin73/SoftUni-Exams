package goldDigger.repositories;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import goldDigger.models.discoverer.Discoverer;

public class DiscovererRepository implements Repository<Discoverer> {
	private Map<String, Discoverer> discoverers;

	public DiscovererRepository() {
		this.discoverers = new LinkedHashMap<>();
	}

	@Override
	public Collection<Discoverer> getCollection() {
		return Collections.unmodifiableCollection(discoverers.values());
	}

	@Override
	public void add(Discoverer discoverer) {
		if (!discoverers.containsKey(discoverer.getName())) {
			discoverers.put(discoverer.getName(), discoverer);
		}
	}

	@Override
	public boolean remove(Discoverer discoverer) {
		return discoverers.remove(discoverer.getName()) != null;
	}

	@Override
	public Discoverer byName(String name) {
		return discoverers.get(name);
	}

}
