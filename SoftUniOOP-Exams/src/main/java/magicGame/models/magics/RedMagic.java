package magicGame.models.magics;

public class RedMagic extends MagicImpl {

	public RedMagic(String name, int bulletsCount) {
		super(name, bulletsCount);
	}

	@Override
	public int fire() {
		int bullets = getBulletsCount();
		if (bullets >= 1) {
			decreaseBullets(1);
			return 1;
		}
		return 0;
	}

}
