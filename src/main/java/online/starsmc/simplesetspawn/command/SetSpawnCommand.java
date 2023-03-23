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

@InjectAll
@Command(names = {"setspawn"}, permission = "simplesetspawn.setspawn")
public class SetSpawnCommand implements CommandClass {

    private Main plugin;

    @Named("spawns")
    private BukkitConfiguration spawnsConfig;

    @Command(names = {""})
    public void mainCommand(@Sender CommandSender sender){
        if(!(sender instanceof Player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        Player player = (Player) sender;

        spawnsConfig.get().set("spawn_location", LocationCodec.serialize(player.getLocation()));
        spawnsConfig.save();
        spawnsConfig.reload();

        ChatUtil.sendMsgPlayerPrefix(player, "&aSpawn correctly set");
    }

    @Command(names = {"firstspawn", "first"}, permission = "simplesetspawn.setspawn.firstspawn")
    public void firstSpawnCommand(@Sender CommandSender sender){
        if(!(sender instanceof Player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        Player player = (Player) sender;

        spawnsConfig.get().set("first_spawn_location", LocationCodec.serialize(player.getLocation()));
        spawnsConfig.save();
        spawnsConfig.reload();

        ChatUtil.sendMsgPlayerPrefix(player, "&aSpawn correctly set");
    }
}
