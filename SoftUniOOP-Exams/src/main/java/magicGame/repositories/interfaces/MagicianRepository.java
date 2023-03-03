package magicGame.repositories.interfaces;

import java.util.Collection;

import magicGame.models.magicians.intefaces.Magician;

public interface MagicianRepository<T> {
    Collection<T> getData();

    void addMagician(Magician model);

    boolean removeMagician(Magician model);

    T findByUsername(String name);
}
