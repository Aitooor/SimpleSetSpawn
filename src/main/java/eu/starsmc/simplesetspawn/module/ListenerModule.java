package eu.starsmc.simplesetspawn.module;

import eu.starsmc.simplesetspawn.listener.PlayerListeners;
import org.bukkit.event.Listener;
import team.unnamed.inject.AbstractModule;

public class ListenerModule extends AbstractModule {

    @Override
    protected void configure() {
        multibind(Listener.class)
                .asSet()
                .to(PlayerListeners.class);
    }
}
