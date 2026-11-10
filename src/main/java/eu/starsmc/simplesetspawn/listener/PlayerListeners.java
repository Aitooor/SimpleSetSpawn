package eu.starsmc.simplesetspawn.listener;

import com.tcoded.folialib.FoliaLib;
import eu.starsmc.simplesetspawn.Main;
import eu.starsmc.simplesetspawn.utils.BukkitConfiguration;
import eu.starsmc.simplesetspawn.utils.ChatUtil;
import eu.starsmc.simplesetspawn.utils.location.LocationCodec;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;

@InjectAll
public class PlayerListeners implements Listener {

    private Main plugin;
    private FoliaLib foliaLib;
    @Named("spawns")
    private BukkitConfiguration spawnsConfig;

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String spawnLocation = spawnsConfig.get().getString("spawn_location");
        String firstSpawnLocation = spawnsConfig.get().getString("first_spawn_location");

        boolean joinSpawnBoolean = plugin.getConfig().getBoolean("onjoin_spawn");
        boolean firstSpawnBoolean = plugin.getConfig().getBoolean("spawn_for_newbies");

        if(spawnLocation == null && joinSpawnBoolean && player.hasPermission("simplesetspawn.admin")) {
            ChatUtil.sendMsgPlayerPrefix(player, "&cRemember to setup Spawn location");
        }

        if(firstSpawnLocation == null && firstSpawnBoolean && player.hasPermission("simplesetspawn.admin")) {
            ChatUtil.sendMsgPlayerPrefix(player, "&cRemember to setup First Spawn location");
        }

        if(plugin.getConfig().getBoolean("on_first_join_spawn")) {
           if(!player.hasPlayedBefore()) {
               if (spawnLocation != null) {
                   Location loc = LocationCodec.deserialize(spawnLocation);
                   if (loc != null) {
                       foliaLib.getImpl().teleportAsync(player, loc);
                   }
               }
           }
        }

        if(firstSpawnBoolean) {
            if(!player.hasPlayedBefore()) {
                if (firstSpawnLocation != null) {
                   Location loc = LocationCodec.deserialize(firstSpawnLocation);
                   if (loc != null) {
                       foliaLib.getImpl().teleportAsync(player, loc);
                   }
                }
            }
        }

        if(player.hasPlayedBefore()) {
            if (joinSpawnBoolean) {
                if (spawnLocation != null) {
                    Location loc = LocationCodec.deserialize(spawnLocation);
                    if (loc != null) {
                        foliaLib.getImpl().teleportAsync(player, loc);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        String spawnLocation = spawnsConfig.get().getString("spawn_location");

        if(plugin.getConfig().getBoolean("on_death_spawn")) {
            if (spawnLocation != null) {
                Location loc = LocationCodec.deserialize(spawnLocation);
                if (loc != null) {
                    foliaLib.getImpl().teleportAsync(player, loc);
                }
            }
        }
    }
}
