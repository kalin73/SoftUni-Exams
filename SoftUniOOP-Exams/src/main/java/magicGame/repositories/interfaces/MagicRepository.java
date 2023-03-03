package magicGame.repositories.interfaces;

import java.util.Collection;

import magicGame.models.magics.interfaces.Magic;

public interface MagicRepository<T> {
    Collection<T> getData();

    void addMagic(Magic model);

    boolean removeMagic(Magic model);

    T findByName(String name);
}
