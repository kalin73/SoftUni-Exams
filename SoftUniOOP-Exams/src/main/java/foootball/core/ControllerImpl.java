package foootball.core;

import java.util.ArrayList;
import java.util.Collection;

import foootball.common.ConstantMessages;
import foootball.common.ExceptionMessages;
import foootball.entities.field.ArtificialTurf;
import foootball.entities.field.Field;
import foootball.entities.field.NaturalGrass;
import foootball.entities.player.Men;
import foootball.entities.player.Player;
import foootball.entities.player.Women;
import foootball.entities.supplement.Liquid;
import foootball.entities.supplement.Powdered;
import foootball.entities.supplement.Supplement;
import foootball.repositories.SupplementRepository;
import foootball.repositories.SupplementRepositoryImpl;

public class ControllerImpl implements Controller {
	private SupplementRepository supplements;
	private Collection<Field> fields;

	public ControllerImpl() {
		this.supplements = new SupplementRepositoryImpl();
		this.fields = new ArrayList<>();
	}

	@Override
	public String addField(String fieldType, String fieldName) {
		Field field;

		switch (fieldType) {
		case "ArtificialTurf":
			field = new ArtificialTurf(fieldName);
			break;

		case "NaturalGrass":
			field = new NaturalGrass(fieldName);
			break;

		default:
			throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);

		}
		this.fields.add(field);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
	}

	@Override
	public String deliverySupplement(String type) {
		Supplement supplement;

		switch (type) {
		case "Powdered":
			supplement = new Powdered();
			break;

		case "Liquid":
			supplement = new Liquid();
			break;

		default:
			throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);

		}
		this.supplements.add(supplement);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
	}

	@Override
	public String supplementForField(String fieldName, String supplementType) {
		Supplement supplement = supplements.findByType(supplementType);

		if (supplement == null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
		}

		Field field = fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);

		field.addSupplement(supplement);
		supplements.remove(supplement);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
	}

	@Override
	public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
		Player player;
		Field field = getFieldByName(fieldName);

		switch (playerType) {
		case "Men":
			player = new Men(playerName, nationality, strength);

			if (field.getClass().getSimpleName().equals("ArtificialTurf")) {
				return ConstantMessages.FIELD_NOT_SUITABLE;
			}
			break;

		case "Women":
			player = new Women(playerName, nationality, strength);

			if (field.getClass().getSimpleName().equals("NaturalGrass")) {
				return ConstantMessages.FIELD_NOT_SUITABLE;
			}
			break;

		default:
			throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);

		}

		field.addPlayer(player);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
	}

	@Override
	public String dragPlayer(String fieldName) {
		Field field = getFieldByName(fieldName);
		field.drag();
		
		int count = field.getPlayers().size();

		return String.format(ConstantMessages.PLAYER_DRAG, count);
	}

	@Override
	public String calculateStrength(String fieldName) {
		Field field = getFieldByName(fieldName);

		int value = field.getPlayers().stream().mapToInt(player -> player.getStrength()).sum();

		return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, value);
	}

	@Override
	public String getStatistics() {
		StringBuilder stats = new StringBuilder();

		fields.forEach(field -> stats.append(field.getInfo()));

		return stats.toString();
	}

	private Field getFieldByName(String fieldName) {
		return fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
	}
}
