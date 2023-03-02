package christmasPastryShop.entities.cocktails;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

public abstract class BaseCocktail implements Cocktail {
	private String name;
	private int size;
	private double price;
	private String brand;

	protected BaseCocktail(String name, int size, double price, String brand) {
		setName(name);
		setSize(size);
		setPrice(price);
		setBrand(brand);
	}

	private void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
		}
		this.name = name;
	}

	private void setSize(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_SIZE);
		}
		this.size = size;
	}

	private void setPrice(double price) {
		if (price <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
		}
		this.price = price;
	}

	private void setBrand(String brand) {
		if (brand == null || brand.trim().isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
		}
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}

	public String getBrand() {
		return brand;
	}

	@Override
	public String toString() {
		return String.format("%s %s - %dml - %.2flv", this.name, this.brand, this.size, this.price);
	}
}
