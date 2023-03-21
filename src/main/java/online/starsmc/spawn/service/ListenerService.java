package online.starsmc.spawn.service;

import online.starsmc.spawn.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import javax.inject.Inject;
import java.util.Set;

public class ListenerService implements Service {

    @Inject
    private Set<Listener> listeners;
    @Inject
    private Main plugin;

    @Override
    public void start() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        listeners.forEach(listener -> pluginManager.registerEvents(listener, plugin));
    }
}
