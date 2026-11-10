package online.starsmc.simplesetspawn.command;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import online.starsmc.simplesetspawn.Main;
import online.starsmc.simplesetspawn.utils.BukkitConfiguration;
import online.starsmc.simplesetspawn.utils.ChatUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;

@InjectAll
@Command(value = "simplesetspawn", alias = {"sss", "ssetspawn", "ssspawn"})
@Permission("simplesetspawn.admin")
public class MainCommand extends BaseCommand {

    private Main plugin;

    @Named("spawns")
    private BukkitConfiguration spawnsConfig;

    @Default
    public void defaultCommand(CommandSender sender) {
        ChatUtil.sendMsgSenderPrefix(sender, "&eSimpleSetSpawn v" + plugin.getDescription().getVersion() + " by &b" + String.join(", ", plugin.getDescription().getAuthors()));
        ChatUtil.sendMsgSenderPrefix(sender, "&eUse &b/simplesetspawn reload &eto reload configuration.");
    }

    @SubCommand(value = "reload", alias = {"rl"})
    @Permission("simplesetspawn.reload")
    public void reloadCommand(CommandSender sender) {
        plugin.reloadConfig();
        spawnsConfig.reload();
        if (!(sender instanceof Player)) {
            ChatUtil.sendMsgSenderPrefix(sender, "&aReloaded correctly");
            return;
        }
        Player player = (Player) sender;
        ChatUtil.sendMsgPlayerPrefix(player, "&aReloaded correctly");
    }
}
