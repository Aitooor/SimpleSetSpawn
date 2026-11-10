package eu.starsmc.simplesetspawn.service;

import eu.starsmc.simplesetspawn.Main;
import eu.starsmc.simplesetspawn.utils.BukkitConfiguration;
import team.unnamed.inject.InjectAll;

import javax.inject.Named;

@InjectAll
public class ConfigurationService implements Service {

    private Main plugin;
    @Named("spawns")
    private BukkitConfiguration spawnsConfig;
    @Override
    public void start() {
        plugin.getLogger().info("Configuration load!");
    }

    @Override
    public void stop() {
        plugin.getLogger().info("Configuration files saved!");
    }
}
