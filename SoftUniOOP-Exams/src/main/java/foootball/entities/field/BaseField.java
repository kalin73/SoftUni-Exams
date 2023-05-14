package foootball.entities.field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import foootball.common.ExceptionMessages;
import foootball.entities.player.Player;
import foootball.entities.supplement.Supplement;

public abstract class BaseField implements Field {
	private String name;
	private int capacity;
	private Collection<Supplement> supplements;
	private Collection<Player> players;

	protected BaseField(String name, int capacity) {
		setName(name);
		this.capacity = capacity;
		this.supplements = new ArrayList<>();
		this.players = new ArrayList<>();
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
		}
		this.name = name;
	}

	@Override
	public int sumEnergy() {
		return this.supplements.stream().mapToInt(e -> e.getEnergy()).sum();
	}

	@Override
	public void addPlayer(Player player) {
		if (capacity == this.players.size()) {
			throw new IllegalArgumentException("Not enough capacity.");
		}
		this.players.add(player);
	}

	@Override
	public void removePlayer(Player player) {
		this.players.remove(player);

	}

	@Override
	public void addSupplement(Supplement supplement) {
		this.supplements.add(supplement);

	}

	@Override
	public void drag() {
		this.players.forEach(player -> player.stimulation());

	}

	@Override
	public String getInfo() {
		return toString();
	}

	@Override
	public Collection<Player> getPlayers() {
		return this.players;
	}

	@Override
	public Collection<Supplement> getSupplements() {
		return this.supplements;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(this.name + " (" + this.getClass().getSimpleName() + "):");
		info.append(System.lineSeparator());
		info.append("Player: ");

		if (players.size() == 0) {
			info.append("none");

		} else {
			info.append(players.stream().map(x -> x.getName()).collect(Collectors.joining(" ")));
		}
		info.append(System.lineSeparator());
		info.append("Supplement: " + this.supplements.size());
		info.append(System.lineSeparator());
		info.append("Energy: " + this.sumEnergy());
		info.append(System.lineSeparator());

		return info.toString().trim();
	}
}
