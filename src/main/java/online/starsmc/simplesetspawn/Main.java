package online.starsmc.simplesetspawn;

import online.starsmc.simplesetspawn.module.PluginModule;
import online.starsmc.simplesetspawn.service.Service;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Injector;

import javax.inject.Inject;
import java.util.Set;

import static org.bukkit.Bukkit.getLogger;

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

        new UpdateChecker(this, 108767).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                getLogger().info("There is not a new update available.");
            } else {
                getLogger().warning("There is a new update available.");
                getLogger().warning("Download it here https://www.spigotmc.org/resources/simplesetspawn-1-8-1-19-simple-setspawn-and-spawn.108767/");
            }
        });
    }

    @Override
    public void onDisable() {
        services.forEach(Service::stop);
    }

}