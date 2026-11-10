package eu.starsmc.simplesetspawn.module;

import dev.triumphteam.cmd.core.BaseCommand;
import eu.starsmc.simplesetspawn.command.MainCommand;
import eu.starsmc.simplesetspawn.command.SetSpawnCommand;
import eu.starsmc.simplesetspawn.command.SpawnCommand;
import team.unnamed.inject.AbstractModule;

public class CommandModule extends AbstractModule {

    @Override
    protected void configure() {
        multibind(BaseCommand.class)
                .asSet()
                .to(MainCommand.class)
                .to(SetSpawnCommand.class)
                .to(SpawnCommand.class);
    }
}
