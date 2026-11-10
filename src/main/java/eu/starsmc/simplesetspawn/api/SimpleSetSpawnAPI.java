package eu.starsmc.simplesetspawn.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public interface SimpleSetSpawnAPI {

    Location getSpawnLocation();

    CompletableFuture<Boolean> teleportToSpawn(Player player);

    void setSpawnLocation(Location location);

    static SimpleSetSpawnAPI get() {
        return InstanceHolder.instance;
    }

    class InstanceHolder {
        public static SimpleSetSpawnAPI instance;
    }
}
