package online.starsmc.spawn.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import online.starsmc.spawn.Main;
import online.starsmc.spawn.utils.ChatUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.unnamed.inject.InjectAll;

@InjectAll
@Command(names = {"hubcore", "sHubCore", "sHubcore", "shubcore", "shubCore"}, permission = "hubcore.admin")
public class MainCommand implements CommandClass {

    private Main plugin;

    @Command(names = {"reload", "rl"}, permission = "hubcore.reload")
    public void reloadCommand(@Sender CommandSender sender){
        if(!(sender instanceof Player)) {
            plugin.reloadConfig();
            ChatUtil.sendMsgSenderPrefix(sender, "&cReloaded correctly");
            return;
        }
        Player player = (Player) sender;
        plugin.reloadConfig();
        ChatUtil.sendMsgPlayerPrefix(player, "&cReloaded correctly");
    }
}
