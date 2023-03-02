package christmasPastryShop.entities.cocktails;

public class MulledWine extends BaseCocktail {
	private static final double MULLED_WINE_PRICE = 3.5;

	public MulledWine(String name, int size, String brand) {
		super(name, size, MULLED_WINE_PRICE, brand);
	}

}
