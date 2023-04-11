package online.starsmc.simplesetspawn.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import online.starsmc.simplesetspawn.Main;
import online.starsmc.simplesetspawn.utils.BukkitConfiguration;
import online.starsmc.simplesetspawn.utils.ChatUtil;
import online.starsmc.simplesetspawn.utils.location.LocationCodec;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;
import java.util.Objects;

@InjectAll
@Command(names = {"spawn"}, permission = "simplesetspawn.spawn")
public class SpawnCommand implements CommandClass {

    private Main plugin;

    @Named("spawns")
    private BukkitConfiguration spawnsConfig;

    @Command(names = {""})
    public void mainCommand(@Sender CommandSender sender){
        String location = spawnsConfig.get().getString("spawn_location");
        if(location != null) {
            Location locationCodec = LocationCodec.deserialize(location);

            if(!(sender instanceof Player player)) {
                ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
                return;
            }

            if (locationCodec != null) {
                player.teleportAsync(locationCodec);

                ChatUtil.sendMsgPlayerPrefix(player, "&aTeleported to Spawn");
                return;
            }

            ChatUtil.sendMsgPlayerPrefix(player, "&cRemember to setup Spawn location");
        }
    }

    @Command(names = {"firstspawn", "first"}, permission = "simplesetspawn.spawn.firstspawn")
    public void firstSpawnCommand(@Sender CommandSender sender){
        String location = spawnsConfig.get().getString("first_spawn_location");
        if (location != null) {
            Location locationCodec = LocationCodec.deserialize(location);

            if(!(sender instanceof Player player)) {
                ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
                return;
            }

            if (locationCodec != null) {
                player.teleportAsync(locationCodec);
                ChatUtil.sendMsgPlayerPrefix(player, "&aTeleported to First Spawn");
                return;
            }
            ChatUtil.sendMsgPlayerPrefix(player, "&cRemember to setup First Spawn location");
        }
    }
}
