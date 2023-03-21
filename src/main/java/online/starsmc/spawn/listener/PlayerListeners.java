package online.starsmc.spawn.listener;

import online.starsmc.spawn.Main;
import online.starsmc.spawn.utils.location.LocationCodec;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.unnamed.inject.InjectAll;

import java.util.Objects;

@InjectAll
public class PlayerListeners implements Listener {

    private Main plugin;
    private FileConfiguration config;

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(plugin.getConfig().getBoolean("first_join_spawn")) {
           if(!player.hasPlayedBefore()) {
               player.teleport(Objects.requireNonNull(LocationCodec.deserialize(Objects.requireNonNull(config.getString("spawn_location")))));
           }
        }

        if(player.hasPlayedBefore()) {
            if (plugin.getConfig().getBoolean("onjoin_spawn")) {
                player.teleport(Objects.requireNonNull(LocationCodec.deserialize(Objects.requireNonNull(config.getString("spawn_location")))));
            }
        }
    }
}
