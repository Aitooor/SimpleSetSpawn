package eu.starsmc.simplesetspawn.service;

import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import dev.triumphteam.cmd.core.BaseCommand;
import eu.starsmc.simplesetspawn.Main;
import org.bukkit.command.CommandSender;

import javax.inject.Inject;
import java.util.Set;

public class CommandService implements Service {
    @Inject
    private Main plugin;
    @Inject
    private Set<BaseCommand> commands;
    private BukkitCommandManager<CommandSender> commandManager;

    @Override
    public void start() {
        commandManager = BukkitCommandManager.create(plugin);
        commands.forEach(commandManager::registerCommand);
    }

    @Override
    public void stop() {
        if (commandManager != null) {
            commands.forEach(commandManager::unregisterCommand);
        }
    }
}
