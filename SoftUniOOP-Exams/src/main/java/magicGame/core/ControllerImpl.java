package magicGame.core;

import java.util.List;
import java.util.stream.Collectors;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Wizard;
import magicGame.models.magicians.intefaces.Magician;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.RedMagic;
import magicGame.models.magics.interfaces.Magic;
import magicGame.models.region.RegionImpl;
import magicGame.models.region.interfaces.Region;
import magicGame.repositories.MagicRepositoryImpl;
import magicGame.repositories.MagicianRepositoryImpl;

public class ControllerImpl implements Controller {
	private MagicRepositoryImpl magic;
	private MagicianRepositoryImpl magicians;
	private Region region;

	public ControllerImpl() {
		this.magic = new MagicRepositoryImpl();
		this.magicians = new MagicianRepositoryImpl();
		this.region = new RegionImpl();
	}

	@Override
	public String addMagic(String type, String name, int bulletsCount) {
		switch (type) {
		case "RedMagic":
			magic.addMagic(new RedMagic(name, bulletsCount));
			break;

		case "BlackMagic":
			magic.addMagic(new BlackMagic(name, bulletsCount));
			break;

		default:
			throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
		}
		return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
	}

	@Override
	public String addMagician(String type, String username, int health, int protection, String magicName) {
		for (Magic m : magic.getData()) {
			if (m.getName().equals(magicName)) {
				switch (type) {
				case "Wizard":
					magicians.addMagician(new Wizard(username, health, protection, m));
					return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);

				case "BlackWidow":
					magicians.addMagician(new BlackWidow(username, health, protection, m));
					return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);

				default:
					throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
				}
			}
		}
		throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
	}

	@Override
	public String startGame() {
		return region.start(magicians.getData());
	}

	@Override
	public String report() {
		StringBuilder report = new StringBuilder();
		List<Magician> mags = magicians.getData().stream()
				.sorted((f, s) -> f.getClass().getSimpleName().compareTo(s.getClass().getSimpleName()))
				.sorted((f, s) -> f.getUsername().compareTo(s.getUsername()))
				.sorted((f, s) -> Integer.compare(f.getHealth(), s.getHealth())).collect(Collectors.toList());

		for (Magician magician : mags) {
			report.append(magician);
			report.append(System.lineSeparator());
		}

		return report.toString().trim();
	}
}
