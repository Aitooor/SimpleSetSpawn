package online.starsmc.simplesetspawn.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import online.starsmc.simplesetspawn.Main;
import online.starsmc.simplesetspawn.utils.ChatUtil;
import online.starsmc.simplesetspawn.utils.location.LocationCodec;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.unnamed.inject.InjectAll;

@InjectAll
@Command(names = {"setspawn"}, permission = "simplesetspawn.setspawn")
public class SetSpawnCommand implements CommandClass {

    private Main plugin;

    @Command(names = {""})
    public void mainCommand(@Sender CommandSender sender){
        if(!(sender instanceof Player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        Player player = (Player) sender;

        plugin.getConfig().set("spawn_location", LocationCodec.serialize(player.getLocation()));
        plugin.saveConfig();
        plugin.reloadConfig();

        ChatUtil.sendMsgPlayerPrefix(player, "&aSpawn correctly set");
    }
}
