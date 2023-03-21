package online.starsmc.spawn.module;

import online.starsmc.spawn.Main;
import online.starsmc.spawn.service.CommandService;
import online.starsmc.spawn.service.Service;
import org.bukkit.configuration.file.FileConfiguration;
import team.unnamed.inject.AbstractModule;

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
                    .to(CommandService.class);

            install(new CommandModule());
            install(new ListenerModule());
        }
}
