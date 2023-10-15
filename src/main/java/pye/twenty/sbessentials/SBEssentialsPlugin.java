package pye.twenty.sbessentials;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SBEssentialsPlugin extends JavaPlugin {


    @Override
    public void onLoad() {
        PacketEventsAPI<Plugin> api = SpigotPacketEventsBuilder.build(this);
        api.getSettings().checkForUpdates(false);
        PacketEvents.setAPI(api);
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {
        SBEssentials.INSTANCE.initialize(this);
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }
}
