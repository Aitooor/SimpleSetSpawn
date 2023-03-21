package online.starsmc.spawn;

import online.starsmc.spawn.module.PluginModule;
import online.starsmc.spawn.service.Service;
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
    }

    @Override
    public void onDisable() {
        services.forEach(Service::stop);
    }

}