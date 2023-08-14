package pye.twenty.sbessentials;

import lombok.Getter;
import pye.twenty.sbessentials.command.Command;
import pye.twenty.sbessentials.command.impl.TestCommand;

@Getter
public enum SBEssentials {

    INSTANCE;

    private SBEssentialsPlugin plugin;

    public void initialize(SBEssentialsPlugin plugin) {
        this.plugin = plugin;
        registerCommands();
    }

    private void registerCommands() {
       addCommand("test", new TestCommand());
    }

    private void addCommand(String command, Command executor) {
        INSTANCE.getPlugin().getCommand(command).setExecutor(executor);
        INSTANCE.getPlugin().getCommand(command).setTabCompleter(executor);
    }
}
