package online.starsmc.simplesetspawn.utils;

import online.starsmc.simplesetspawn.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public interface ChatUtil {

    Main plugin = Main.getPlugin(Main.class);

    static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    static List<String> translate(List<String> stringList) {
        List<String> arrayList = new ArrayList<>();
        for (String list : stringList) {
            arrayList.add(translate(list));
        }
        return arrayList;
    }

    static void sendMsgPlayer(Player player, String message) {
        player.sendMessage(translate(message).replace("<player>", player.getName()));
    }
    static void sendMsgPlayerPrefix(Player player, String message) {
        sendMsgPlayer(player, getPrefixGame() + message);
    }

    static void sendMsgPlayer(Player player, List<String> stringList) {
        stringList.forEach(message -> sendMsgPlayer(player, message));
    }

    static void sendMsgPlayerPrefix(Player player, List<String> stringList) {
        stringList.forEach(message -> sendMsgPlayerPrefix(player, message));
    }

    static void sendMsgSender(CommandSender sender, String message) {
        sender.sendMessage(translate(message));
    }

    static void sendMsgSenderPrefix(CommandSender sender, String message) {
        sendMsgSender(sender, getPrefixGame() + message);
    }

    static void sendMsgSender(CommandSender sender, List<String> stringList) {
        stringList.forEach(message -> sendMsgSender(sender, message));
    }

    static void sendMsgSenderPrefix(CommandSender sender, List<String> stringList) {
        stringList.forEach(message -> sendMsgSenderPrefix(sender, message));
    }

    static String getPrefixGame() {
        return plugin.getConfig().getString("prefix");
    }

    static String getPrefix() {
        return "[SimpleSetSpawn] ";
    }

}
