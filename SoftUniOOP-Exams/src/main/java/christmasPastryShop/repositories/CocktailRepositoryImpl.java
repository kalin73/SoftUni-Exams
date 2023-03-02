package christmasPastryShop.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {
	private Collection<Cocktail> cocktails;

	public CocktailRepositoryImpl() {
		this.cocktails = new ArrayList<>();
	}

	@Override
	public Cocktail getByName(String name) {
		for (Cocktail cocktail : cocktails) {
			if (cocktail.getName().equals(name)) {
				return cocktail;
			}
		}
		return null;
	}

	@Override
	public Collection<Cocktail> getAll() {
		return Collections.unmodifiableCollection(cocktails);
	}

	@Override
	public void add(Cocktail entity) {
		cocktails.add(entity);

	}

}
