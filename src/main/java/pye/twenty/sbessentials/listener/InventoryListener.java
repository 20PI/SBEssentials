package pye.twenty.sbessentials.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import pye.twenty.sbessentials.SBEssentials;

public class InventoryListener implements Listener {

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        SBEssentials.getGUI((Player) event.getWhoClicked()).ifPresent(gui -> {
            gui.onInventoryClick(event);
        });
    }

    @EventHandler
    private void onInventoryDrag(InventoryDragEvent event) {
        SBEssentials.getGUI((Player) event.getWhoClicked()).ifPresent(gui -> {
            gui.onInventoryDrag(event);
        });
    }

    @EventHandler
    private void onInventoryClose(InventoryCloseEvent event) {
        SBEssentials.getGUI((Player) event.getPlayer()).ifPresent(gui -> {
            gui.onInventoryClose(event);
        });
        SBEssentials.INSTANCE.getGuiRegistry().remove(event.getPlayer().getUniqueId());
    }
}
