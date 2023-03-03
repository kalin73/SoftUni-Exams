package magicGame.models.magicians.intefaces;

import magicGame.models.magics.interfaces.Magic;

public interface Magician {
    String getUsername();

    int getHealth();

    int getProtection();

    Magic getMagic();

    boolean isAlive();

    void takeDamage(int points);
}
