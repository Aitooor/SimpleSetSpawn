package online.starsmc.simplesetspawn.module;

import me.fixeddev.commandflow.annotated.CommandClass;
import online.starsmc.simplesetspawn.command.MainCommand;
import online.starsmc.simplesetspawn.command.SetSpawnCommand;
import online.starsmc.simplesetspawn.command.SpawnCommand;
import team.unnamed.inject.AbstractModule;

public class CommandModule extends AbstractModule {

        @Override
        protected void configure() {
            multibind(CommandClass.class)
                    .asSet()
                    .to(MainCommand.class)
                    .to(SetSpawnCommand.class)
                    .to(SpawnCommand.class);
        }
}
