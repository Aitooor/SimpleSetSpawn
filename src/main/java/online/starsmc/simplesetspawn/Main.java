package online.starsmc.simplesetspawn;

import online.starsmc.simplesetspawn.module.PluginModule;
import online.starsmc.simplesetspawn.service.Service;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Injector;

import javax.inject.Inject;
import java.util.Set;

public class Main extends JavaPlugin {
    @Inject
    private Set<Service> services;

    @Override
    public void onLoad() {
        Injector injector = Injector.create(new PluginModule(this));
        injector.injectMembers(this);
    }
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        services.forEach(Service::start);

        String serverVersion = this.getDescription().getVersion();

        new UpdateChecker(this, 108767).getVersion(version -> {
            if (serverVersion.equals(version)) {
                getLogger().info("Current Version: " + serverVersion);
                getLogger().info("No new version available.");
            } else {
                getLogger().warning("Found new version: " + version);
                getLogger().warning("Your version: " + serverVersion);
                getLogger().warning("Download it here https://www.spigotmc.org/resources/simplesetspawn-1-8-1-19-simple-setspawn-and-spawn.108767/");
            }
        });
    }

    @Override
    public void onDisable() {
        services.forEach(Service::stop);
    }

}