package online.starsmc.simplesetspawn.command;

import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import online.starsmc.simplesetspawn.Main;
import online.starsmc.simplesetspawn.utils.BukkitConfiguration;
import online.starsmc.simplesetspawn.utils.ChatUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;

@InjectAll
@Command(names = {"SimpleSetSpawn", "sss", "ssetspawn", "ssspawn"}, permission = "simplesetspawn.admin")
public class MainCommand implements CommandClass {

    private Main plugin;

    @Named("spawns")
    private BukkitConfiguration spawnsConfig;

    @Command(names = {"reload", "rl"}, permission = "simplesetspawn.reload")
    public void reloadCommand(@Sender CommandSender sender){
        if(!(sender instanceof Player)) {
            plugin.reloadConfig();
            ChatUtil.sendMsgSenderPrefix(sender, "&cReloaded correctly");
            return;
        }
        Player player = (Player) sender;
        plugin.reloadConfig();
        spawnsConfig.reload();
        ChatUtil.sendMsgPlayerPrefix(player, "&cReloaded correctly");
    }
}
