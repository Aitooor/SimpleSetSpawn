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

import java.util.Objects;

@InjectAll
@Command(names = {"spawn"}, permission = "sspawn.spawn")
public class SpawnCommand implements CommandClass {

    private Main plugin;

    @Command(names = {""})
    public void mainCommand(@Sender CommandSender sender){
        if(!(sender instanceof Player)) {
            ChatUtil.sendMsgSender(sender, "&cThis command only can execute in game");
            return;
        }

        Player player = (Player) sender;

        player.teleport(
                Objects.requireNonNull(LocationCodec.deserialize(
                        Objects.requireNonNull(plugin.getConfig().getString("spawn_location"))
                ))
        );
        ChatUtil.sendMsgPlayerPrefix(player, "&aTeleported to spawn");
    }
}
