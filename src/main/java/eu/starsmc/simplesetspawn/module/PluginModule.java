package eu.starsmc.simplesetspawn.module;

import com.tcoded.folialib.FoliaLib;
import eu.starsmc.simplesetspawn.Main;
import eu.starsmc.simplesetspawn.service.CommandService;
import eu.starsmc.simplesetspawn.service.ConfigurationService;
import eu.starsmc.simplesetspawn.service.ListenerService;
import eu.starsmc.simplesetspawn.service.Service;
import eu.starsmc.simplesetspawn.utils.BukkitConfiguration;
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

            FoliaLib foliaLib = new FoliaLib(plugin);
            bind(FoliaLib.class).toInstance(foliaLib);

            multibind(Service.class)
                    .asSet()
                    .to(CommandService.class)
                    .to(ListenerService.class)
                    .to(ConfigurationService.class);

            bind(BukkitConfiguration.class)
                    .named("spawns")
                    .toInstance(new BukkitConfiguration(plugin, "spawns"));

            install(new CommandModule());
            install(new ListenerModule());
        }
}
