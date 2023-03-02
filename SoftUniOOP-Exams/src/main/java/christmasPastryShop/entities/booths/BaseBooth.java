package christmasPastryShop.entities.booths;

import java.util.ArrayList;
import java.util.Collection;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

public abstract class BaseBooth implements Booth {
	private Collection<Delicacy> delicacyOrders;
	private Collection<Cocktail> cocktailOrders;
	private int boothNumber;
	private int capacity;
	private int numberOfPeople;
	private double pricePerPerson;
	private boolean isReserved;
	private double price;

	protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
		this.delicacyOrders = new ArrayList<>();
		this.cocktailOrders = new ArrayList<>();
		this.boothNumber = boothNumber;
		setCapacity(capacity);
		this.pricePerPerson = pricePerPerson;
		this.numberOfPeople = 0;
	}

	private void setCapacity(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
		}
		this.capacity = capacity;
	}

	@Override
	public int getBoothNumber() {
		return this.boothNumber;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public boolean isReserved() {
		return this.isReserved;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void reserve(int numberOfPeople) {
		if (numberOfPeople <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
		}
		this.numberOfPeople = numberOfPeople;
		this.price = this.numberOfPeople * pricePerPerson;
		this.isReserved = true;

	}

	@Override
	public double getBill() {
		double bill = 0.0;
		bill = this.delicacyOrders.stream().mapToDouble(delic -> delic.getPrice()).sum();
		bill += this.cocktailOrders.stream().mapToDouble(cocktail -> cocktail.getPrice()).sum();
		bill += getPrice();

		return bill;
	}

	@Override
	public void clear() {
		this.delicacyOrders.clear();
		this.cocktailOrders.clear();
		this.numberOfPeople = 0;
		this.isReserved = false;
		this.price = 0.0;
	}

}
