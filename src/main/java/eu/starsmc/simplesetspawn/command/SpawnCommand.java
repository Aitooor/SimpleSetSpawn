package eu.starsmc.simplesetspawn.command;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import eu.starsmc.simplesetspawn.Main;
import eu.starsmc.simplesetspawn.utils.BukkitConfiguration;
import eu.starsmc.simplesetspawn.utils.ChatUtil;
import eu.starsmc.simplesetspawn.utils.location.LocationCodec;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;

@InjectAll
@Command(value = "spawn")
public class SpawnCommand extends BaseCommand {

    private Main plugin;

    @Named("spawns")
    private BukkitConfiguration spawnsConfig;

    @Default
    @Permission("simplesetspawn.spawn")
    public void mainCommand(CommandSender sender) {
        if (!(sender instanceof Player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        Player player = (Player) sender;
        String location = spawnsConfig.get().getString("spawn_location");
        if (location != null) {
            Location locationCodec = LocationCodec.deserialize(location);
            if (locationCodec != null) {
                player.teleport(locationCodec);
                ChatUtil.sendMsgPlayerPrefix(player, "&aTeleported to Spawn");
            }
        }
    }

    @SubCommand(value = "firstspawn", alias = {"first"})
    @Permission("simplesetspawn.spawn.firstspawn")
    public void firstSpawnCommand(CommandSender sender) {
        if (!(sender instanceof Player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        Player player = (Player) sender;
        String location = spawnsConfig.get().getString("first_spawn_location");
        if (location != null) {
            Location locationCodec = LocationCodec.deserialize(location);
            if (locationCodec != null) {
                player.teleport(locationCodec);
            }
            ChatUtil.sendMsgPlayerPrefix(player, "&aTeleported to First Spawn");
        }
    }
}
