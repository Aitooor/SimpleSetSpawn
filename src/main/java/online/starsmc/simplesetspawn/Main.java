package online.starsmc.simplesetspawn;

import online.starsmc.simplesetspawn.utils.external.metric.Metric;
import online.starsmc.simplesetspawn.module.PluginModule;
import online.starsmc.simplesetspawn.service.Service;
import online.starsmc.simplesetspawn.utils.external.updater.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;
import team.unnamed.inject.Injector;

import javax.inject.Inject;
import java.util.Set;

public class Main extends JavaPlugin {
    @Inject
    private Set<Service> services;
    private final Metric metric = new Metric(this);

    @Override
    public void onLoad() {
        Injector injector = Injector.create(new PluginModule(this));
        injector.injectMembers(this);
    }
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        services.forEach(Service::start);

        new UpdateChecker(this, 108767).start();
        metric.load();
    }

    @Override
    public void onDisable() {
        services.forEach(Service::stop);
        metric.disable();
    }

}