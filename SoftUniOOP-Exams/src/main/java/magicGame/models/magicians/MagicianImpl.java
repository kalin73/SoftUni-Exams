package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.intefaces.Magician;
import magicGame.models.magics.interfaces.Magic;

public abstract class MagicianImpl implements Magician {
	private String username;
	private int health;
	private int protection;
	private boolean isAlive;
	private Magic magic;

	protected MagicianImpl(String username, int health, int protection, Magic magic) {
		setUsername(username);
		setHealth(health);
		setProtection(protection);
		setMagic(magic);
		this.isAlive = true;
	}

	private void setUsername(String username) {
		if (username == null || username.trim().isEmpty()) {
			throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
		}
		this.username = username;
	}

	private void setHealth(int health) {
		if (health <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
		}
		this.health = health;
	}

	private void setProtection(int protection) {
		if (protection < 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
		}
		this.protection = protection;
	}

	private void setMagic(Magic magic) {
		if (magic == null) {
			throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
		}
		this.magic = magic;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public int getProtection() {
		return this.protection;
	}

	@Override
	public Magic getMagic() {
		return this.magic;
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public void takeDamage(int points) {
		if (protection >= points) {
			this.protection -= points;

		} else {
			this.health -= points - protection;
			this.protection = 0;
		}

		this.isAlive = health > 0 ? true : false;

	}

	@Override
	public String toString() {
		return String.format("%s: %s%nHealth: %d%nProtection: %d%nMagic: %s", this.getClass().getSimpleName(),
				this.username, this.health, this.protection, this.magic.getName());
	}
}
