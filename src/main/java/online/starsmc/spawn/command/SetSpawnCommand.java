package online.starsmc.spawn.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import online.starsmc.spawn.Main;
import online.starsmc.spawn.utils.ChatUtil;
import online.starsmc.spawn.utils.location.LocationCodec;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.unnamed.inject.InjectAll;

@InjectAll
@Command(names = {"setspawn"}, permission = "sspawn.setspawn")
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
