package magicGame.models.magics;

public class BlackMagic extends MagicImpl {

	public BlackMagic(String name, int bulletsCount) {
		super(name, bulletsCount);
	}

	@Override
	public int fire() {
		int bullets = getBulletsCount();
		if (bullets >= 10) {
			decreaseBullets(10);;
			return 10;
		}
		return 0;
	}
}
