package pye.twenty.sbessentials.gui.impl;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pye.twenty.sbessentials.gui.GUI;

public class TestGUI extends GUI {

    @Override
    protected void initialize() {
        addSlot(10, new ItemStack(Material.DIRT), e -> {
            player.getInventory().setItemInMainHand(new ItemStack(Material.DIRT));
        });
    }

}
