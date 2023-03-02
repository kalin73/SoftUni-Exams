package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {
	private DelicacyRepository<Delicacy> delicacyRepository;
	private CocktailRepository<Cocktail> cocktailRepository;
	private BoothRepository<Booth> boothRepository;
	private double income;

	public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
			CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
		this.delicacyRepository = delicacyRepository;
		this.cocktailRepository = cocktailRepository;
		this.boothRepository = boothRepository;
		this.income = 0;
	}

	@Override
	public String addDelicacy(String type, String name, double price) {
		if (delicacyRepository.getByName(name) != null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
		}

		switch (type) {
		case "Gingerbread":
			delicacyRepository.add(new Gingerbread(name, price));
			break;
		case "Stolen":
			delicacyRepository.add(new Stolen(name, price));
			break;

		default:
			break;
		}

		return String.format(OutputMessages.DELICACY_ADDED, name, type);
	}

	@Override
	public String addCocktail(String type, String name, int size, String brand) {
		if (cocktailRepository.getByName(name) != null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
		}

		switch (type) {
		case "Hibernation":
			cocktailRepository.add(new Hibernation(name, size, brand));
			break;
		case "MulledWine":
			cocktailRepository.add(new MulledWine(name, size, brand));
			break;

		default:
			break;
		}

		return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
	}

	@Override
	public String addBooth(String type, int boothNumber, int capacity) {
		if (boothRepository.getByNumber(boothNumber) != null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
		}

		switch (type) {
		case "OpenBooth":
			boothRepository.add(new OpenBooth(boothNumber, capacity));
			break;
		case "PrivateBooth":
			boothRepository.add(new PrivateBooth(boothNumber, capacity));
			break;

		default:
			break;
		}

		return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
	}

	@Override
	public String reserveBooth(int numberOfPeople) {
		for (Booth booth : boothRepository.getAll()) {
			if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople) {
				booth.reserve(numberOfPeople);
				return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
			}
		}
		return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
	}

	@Override
	public String leaveBooth(int boothNumber) {
		double currentBill = 0.0;
		for (Booth booth : boothRepository.getAll()) {
			if (booth.getBoothNumber() == boothNumber) {
				currentBill = booth.getBill();
				income += currentBill;
				booth.clear();
				break;
			}
		}
		return String.format(OutputMessages.BILL, boothNumber, currentBill);
	}

	@Override
	public String getIncome() {
		return String.format(OutputMessages.TOTAL_INCOME, this.income);
	}
}
