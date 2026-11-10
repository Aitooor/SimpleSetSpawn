package online.starsmc.simplesetspawn.command;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import online.starsmc.simplesetspawn.Main;
import online.starsmc.simplesetspawn.utils.BukkitConfiguration;
import online.starsmc.simplesetspawn.utils.ChatUtil;
import online.starsmc.simplesetspawn.utils.location.LocationCodec;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;

@InjectAll
@Command(value = "setspawn")
public class SetSpawnCommand extends BaseCommand {

    private Main plugin;

    @Named("spawns")
    private BukkitConfiguration spawnsConfig;

    @Default
    @Permission("simplesetspawn.setspawn")
    public void mainCommand(CommandSender sender) {
        if (!(sender instanceof Player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        Player player = (Player) sender;

        spawnsConfig.get().set("spawn_location", LocationCodec.serialize(player.getLocation()));
        spawnsConfig.save();

        ChatUtil.sendMsgPlayerPrefix(player, "&aSpawn correctly set");
    }

    @SubCommand(value = "firstspawn", alias = {"first"})
    @Permission("simplesetspawn.setspawn.firstspawn")
    public void firstSpawnCommand(CommandSender sender) {
        if (!(sender instanceof Player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        Player player = (Player) sender;

        spawnsConfig.get().set("first_spawn_location", LocationCodec.serialize(player.getLocation()));
        spawnsConfig.save();

        ChatUtil.sendMsgPlayerPrefix(player, "&aFirst Spawn correctly set");
    }
}
