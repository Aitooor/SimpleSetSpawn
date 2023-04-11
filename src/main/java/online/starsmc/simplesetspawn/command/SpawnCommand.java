package online.starsmc.simplesetspawn.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import online.starsmc.simplesetspawn.Main;
import online.starsmc.simplesetspawn.utils.BukkitConfiguration;
import online.starsmc.simplesetspawn.utils.ChatUtil;
import online.starsmc.simplesetspawn.utils.location.LocationCodec;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
        if(!(sender instanceof Player player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        player.teleportAsync(
                Objects.requireNonNull(LocationCodec.deserialize(
                        Objects.requireNonNull(spawnsConfig.get().getString("spawn_location"))
                ))
        );
        ChatUtil.sendMsgPlayerPrefix(player, "&aTeleported to Spawn");
    }

    @Command(names = {"firstspawn", "first"}, permission = "simplesetspawn.spawn.firstspawn")
    public void firstSpawnCommand(@Sender CommandSender sender){
        if(!(sender instanceof Player player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        player.teleportAsync(
                Objects.requireNonNull(LocationCodec.deserialize(
                        Objects.requireNonNull(spawnsConfig.get().getString("first_spawn_location"))
                ))
        );
        ChatUtil.sendMsgPlayerPrefix(player, "&aTeleported to First Spawn");
    }
}
