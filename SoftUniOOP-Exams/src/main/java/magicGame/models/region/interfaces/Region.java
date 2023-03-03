package magicGame.models.region.interfaces;

import java.util.Collection;

import magicGame.models.magicians.intefaces.Magician;

public interface Region {
    String start(Collection<Magician> magicians);

}
