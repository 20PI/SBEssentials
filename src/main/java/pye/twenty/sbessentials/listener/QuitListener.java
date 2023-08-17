package pye.twenty.sbessentials.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pye.twenty.sbessentials.SBEssentials;

public class QuitListener implements Listener {

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        SBEssentials.INSTANCE.getGuiRegistry().remove(event.getPlayer().getUniqueId());
    }

}
