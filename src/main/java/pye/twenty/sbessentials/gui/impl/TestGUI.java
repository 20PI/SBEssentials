package pye.twenty.sbessentials.gui.impl;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pye.twenty.sbessentials.gui.GUI;
import pye.twenty.sbessentials.util.ItemBuilder;

public class TestGUI extends GUI {

    @Override
    protected void initialize() {
        addSlot(10, new ItemStack(Material.DIRT), e -> {
            signInput(new String[] {
                    "first line",
                    "second line",
                    "third line",
            }, input -> {
                player.setItemOnCursor(new ItemBuilder(Material.DIRT).name(input).build());
            });
        });
    }

}
