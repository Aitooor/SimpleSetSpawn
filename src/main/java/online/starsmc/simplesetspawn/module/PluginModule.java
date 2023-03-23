package online.starsmc.simplesetspawn.module;

import online.starsmc.simplesetspawn.Main;
import online.starsmc.simplesetspawn.UpdateChecker;
import online.starsmc.simplesetspawn.service.CommandService;
import online.starsmc.simplesetspawn.service.ListenerService;
import online.starsmc.simplesetspawn.service.Service;
import org.bukkit.configuration.file.FileConfiguration;
import team.unnamed.inject.AbstractModule;

import static org.bukkit.Bukkit.getLogger;

public class PluginModule extends AbstractModule {
        private final Main plugin;

        public PluginModule(Main plugin) {
            this.plugin = plugin;
        }

        @Override
        protected void configure() {
            FileConfiguration config = plugin.getConfig();

            bind(Main.class).toInstance(plugin);
            bind(FileConfiguration.class).toInstance(config);

            multibind(Service.class)
                    .asSet()
                    .to(CommandService.class)
                    .to(ListenerService.class);

            install(new CommandModule());
            install(new ListenerModule());
        }
}
