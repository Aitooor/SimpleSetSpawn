package online.starsmc.spawn.module;

import me.fixeddev.commandflow.annotated.CommandClass;
import online.starsmc.spawn.command.MainCommand;
import team.unnamed.inject.AbstractModule;

public class CommandModule extends AbstractModule {

        @Override
        protected void configure() {
            multibind(CommandClass.class).asSet().to(MainCommand.class);
        }
}
