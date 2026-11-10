package eu.starsmc.simplesetspawn.api;

import com.tcoded.folialib.FoliaLib;
import eu.starsmc.simplesetspawn.utils.BukkitConfiguration;
import eu.starsmc.simplesetspawn.utils.location.LocationCodec;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class SimpleSetSpawnAPIImpl implements SimpleSetSpawnAPI {

    private final BukkitConfiguration spawnsConfig;
    private final FoliaLib foliaLib;

    public SimpleSetSpawnAPIImpl(BukkitConfiguration spawnsConfig, FoliaLib foliaLib) {
        this.spawnsConfig = spawnsConfig;
        this.foliaLib = foliaLib;
    }

    @Override
    public Location getSpawnLocation() {
        String locStr = spawnsConfig.get().getString("spawn_location");
        return locStr != null ? LocationCodec.deserialize(locStr) : null;
    }

    @Override
    public CompletableFuture<Boolean> teleportToSpawn(Player player) {
        Location loc = getSpawnLocation();
        if (loc == null || player == null) {
            CompletableFuture<Boolean> future = new CompletableFuture<>();
            future.complete(false);
            return future;
        }
        return foliaLib.getImpl().teleportAsync(player, loc);
    }

    @Override
    public void setSpawnLocation(Location location) {
        if (location == null) return;
        spawnsConfig.get().set("spawn_location", LocationCodec.serialize(location));
        spawnsConfig.save();
    }
}
