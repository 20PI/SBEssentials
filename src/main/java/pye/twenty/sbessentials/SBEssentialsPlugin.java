package pye.twenty.sbessentials;

import org.bukkit.plugin.java.JavaPlugin;

public final class SBEssentialsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        SBEssentials.INSTANCE.initialize(this);
    }

    @Override
    public void onDisable() {
    }
}
