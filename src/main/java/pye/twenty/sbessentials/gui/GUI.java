package pye.twenty.sbessentials.gui;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class GUI {

    private final int size = getClass().isAnnotationPresent(Slots.class) ? getClass().getAnnotation(Slots.class).slots() : 27;
    private final String label = getClass().isAnnotationPresent(Label.class) ? getClass().getAnnotation(Label.class).label() : "Chest";
    private final Map<Integer, SlotAction> actionMap = new HashMap<>();

    protected Player player;
    protected Inventory inventory;

    public void open(Player player) {
        open(player, label);
    }

    public void open(Player player, String label) {
        this.player = player;
        inventory = Bukkit.createInventory(null, size, Component.text(label));
        initialize();
        player.openInventory(inventory);
    }

    protected abstract void initialize();

    protected void addSlot(int slot, ItemStack stack, SlotAction action) {
        inventory.setItem(slot, stack);
        actionMap.put(slot, action);
    }

    public void onInventoryClick(InventoryClickEvent event) {
        if (inventory != null && event.getInventory().equals(inventory)) {
            Integer clickedSlot = event.getSlot();

            actionMap.keySet().stream()
                    .filter(slot -> slot.equals(clickedSlot))
                    .findFirst()
                    .map(actionMap::get)
                    .ifPresent(action -> action.action(event));
        }
    }

    public void onInventoryDrag(InventoryDragEvent event) {

    }

    public void onInventoryClose(InventoryCloseEvent event) {

    }


}
