package pye.twenty.sbessentials;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pye.twenty.sbessentials.command.SBCommand;
import pye.twenty.sbessentials.command.impl.TestCommand;
import pye.twenty.sbessentials.gui.GUI;
import pye.twenty.sbessentials.listener.InventoryListener;
import pye.twenty.sbessentials.listener.QuitListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Getter
public enum SBEssentials {

    INSTANCE;

    private final Map<UUID, GUI> guiRegistry = new HashMap<>();
    private SBEssentialsPlugin plugin;

    public void initialize(SBEssentialsPlugin plugin) {
        this.plugin = plugin;

        registerListeners();
        registerCommands();
    }

    private void registerCommands() {
        addCommand("test", new TestCommand(), plugin);
    }

    private void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(new InventoryListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new QuitListener(), plugin);

    }

    public static void addCommand(String command, SBCommand executor, JavaPlugin plugin) {
        plugin.getCommand(command).setExecutor(executor);
        plugin.getCommand(command).setTabCompleter(executor);
    }

    public static void openGUI(Player player, GUI gui) {
        INSTANCE.guiRegistry.put(player.getUniqueId(), gui);
        gui.open(player);
    }

    public static Optional<GUI> getGUI(Player player) {
        UUID uuid = player.getUniqueId();
        if (INSTANCE.guiRegistry.containsKey(uuid)) {
            return Optional.of(INSTANCE.guiRegistry.get(uuid));
        }
        return Optional.empty();
    }
}
