package pye.twenty.sbessentials.util;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class GUIUtils {

    public static void fillRow(Inventory inventory, int row, ItemStack stack) {
        for (int i = 0; i < 9; i++) {
            inventory.setItem(9 * (row - 1) + i, stack);
        }
    }

    public static void fillInventory(Inventory inventory, ItemStack stack) {
        for (int slot = 0; slot < inventory.getSize(); slot++) {
            inventory.setItem(slot, stack);
        }
    }

    public static ItemStack blank() {
        return blank(Material.BLACK_STAINED_GLASS_PANE);
    }

    public static ItemStack blank(Material material) {
        ItemStack blank = new ItemStack(material, 1);
        ItemMeta blankMeta = blank.getItemMeta();
        blankMeta.setDisplayName("§7 ");
        blank.setItemMeta(blankMeta);
        return blank;
    }

    public static ItemStack air() {
        return new ItemStack(Material.AIR);
    }

}
