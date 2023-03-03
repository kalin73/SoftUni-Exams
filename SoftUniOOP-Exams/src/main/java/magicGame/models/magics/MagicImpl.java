package magicGame.models.magics;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.interfaces.Magic;

public abstract class MagicImpl implements Magic {
	private String name;
	private int bulletsCount;

	protected MagicImpl(String name, int bulletsCount) {
		setName(name);
		setBulletsCount(bulletsCount);
	}

	private void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
		}
		this.name = name;
	}

	public void setBulletsCount(int bulletsCount) {
		if (bulletsCount <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
		}
		this.bulletsCount = bulletsCount;
	}

	public void decreaseBullets(int value) {
		this.bulletsCount -= value;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getBulletsCount() {
		return this.bulletsCount;
	}

}
