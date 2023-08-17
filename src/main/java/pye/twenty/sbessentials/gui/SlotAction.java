package pye.twenty.sbessentials.gui;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface SlotAction {
    void action(InventoryClickEvent event);
}
