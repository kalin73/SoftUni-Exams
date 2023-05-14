package foootball.entities.field;

import java.util.Collection;

import foootball.entities.player.Player;
import foootball.entities.supplement.Supplement;

public interface Field {
    int sumEnergy();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void addSupplement(Supplement supplement);

    void drag();

    String getInfo();

    Collection<Player> getPlayers();

    Collection<Supplement> getSupplements();

    String getName();
}
