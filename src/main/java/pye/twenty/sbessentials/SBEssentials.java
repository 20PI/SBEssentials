package pye.twenty.sbessentials;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
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
       addCommand("test", new TestCommand(), plugin);
    }

    public static void addCommand(String command, Command executor, JavaPlugin plugin) {
        plugin.getCommand(command).setExecutor(executor);
        plugin.getCommand(command).setTabCompleter(executor);
    }
}
