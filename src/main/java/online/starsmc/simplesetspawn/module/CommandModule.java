package online.starsmc.simplesetspawn.module;

import dev.triumphteam.cmd.core.BaseCommand;
import online.starsmc.simplesetspawn.command.MainCommand;
import online.starsmc.simplesetspawn.command.SetSpawnCommand;
import online.starsmc.simplesetspawn.command.SpawnCommand;
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
