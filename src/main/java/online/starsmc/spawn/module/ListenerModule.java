package online.starsmc.spawn.module;

import online.starsmc.spawn.listener.PlayerListeners;
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
