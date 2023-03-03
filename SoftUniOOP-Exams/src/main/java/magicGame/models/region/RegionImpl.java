package magicGame.models.region;

import java.util.ArrayDeque;
import java.util.Collection;

import magicGame.models.magicians.intefaces.Magician;
import magicGame.models.region.interfaces.Region;

public class RegionImpl implements Region {

	@Override
	public String start(Collection<Magician> magicians) {
		ArrayDeque<Magician> wizards = new ArrayDeque<>();
		ArrayDeque<Magician> blackWidows = new ArrayDeque<>();

		for (Magician magician : magicians) {
			if (magician.getClass().getSimpleName().equals("Wizard")) {
				wizards.offer(magician);

			} else {
				blackWidows.offer(magician);
			}
		}
		return fight(wizards, blackWidows);
	}

	private String fight(ArrayDeque<Magician> wizards, ArrayDeque<Magician> blackWidows) {
		while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
			Magician wiz = wizards.getFirst();
			Magician blc = blackWidows.getFirst();

			if (hasBulletsLeft(wiz)) {
				wizards.offer(wizards.remove());
				continue;

			} else {
				blc.takeDamage(wiz.getMagic().fire());

			}
			if (blc.isAlive()) {
				if (hasBulletsLeft(blc)) {
					blackWidows.offer(blackWidows.remove());
					blc = blackWidows.getFirst();
					
				}
				wiz.takeDamage(blc.getMagic().fire());
				blackWidows.offer(blackWidows.remove());
				
			} else {
				blackWidows.remove();
			}

			if (!wiz.isAlive()) {
				wizards.remove();
			}
			wizards.offer(wizards.remove());

		}

		if (wizards.isEmpty()) {
			return "Black widows win!";
		}
		return "Wizards win!";
	}

	private boolean hasBulletsLeft(Magician mag) {
		if (mag.getMagic().getClass().getSimpleName().equals("BlackMagic")) {
			return mag.getMagic().getBulletsCount() < 10;
		}

		return mag.getMagic().getBulletsCount() < 1;
	}
}
