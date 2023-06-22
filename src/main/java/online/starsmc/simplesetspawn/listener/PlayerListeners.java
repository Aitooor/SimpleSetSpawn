package online.starsmc.simplesetspawn.listener;

import online.starsmc.simplesetspawn.Main;
import online.starsmc.simplesetspawn.utils.BukkitConfiguration;
import online.starsmc.simplesetspawn.utils.ChatUtil;
import online.starsmc.simplesetspawn.utils.location.LocationCodec;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;
import java.util.Objects;

@InjectAll
public class PlayerListeners implements Listener {

    private Main plugin;
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
                   player.teleport(Objects.requireNonNull(LocationCodec.deserialize(spawnLocation)));
               }
           }
        }

        if(firstSpawnBoolean) {
            if(!player.hasPlayedBefore()) {
                if (firstSpawnLocation != null) {
                   player.teleport(Objects.requireNonNull(LocationCodec.deserialize(firstSpawnLocation)));
                }
            }
        }

        if(player.hasPlayedBefore()) {
            if (joinSpawnBoolean) {
                if (spawnLocation != null) {
                    player.teleport(Objects.requireNonNull(LocationCodec.deserialize(spawnLocation)));
                }
            }
        }
    }

    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        String spawnLocation = spawnsConfig.get().getString("spawn_location");

        if(plugin.getConfig().getBoolean("on_death_spawn")) {
            Bukkit.getScheduler().runTask(Main.getPlugin(Main.class), bukkitTask -> Objects.requireNonNull(player).teleport(Objects.requireNonNull(LocationCodec.deserialize(Objects.requireNonNull(spawnLocation)))));
        }
    }
}
