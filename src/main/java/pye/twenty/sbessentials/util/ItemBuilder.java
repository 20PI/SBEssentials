package pye.twenty.sbessentials.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private Material material;
    private int amount;
    private String name;
    private List<String> lore;
    private boolean shiny;

    public ItemBuilder(Material material) {
        this.material = material;
        this.name = "§f" + StringUtils.capitalizeWord(material.name().replace("_", " ").toLowerCase());
        this.lore = new ArrayList<>();
        this.amount = 1;
    }

    public ItemBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder lore(String lore) {
        this.lore.add(lore);
        return this;
    }

    public ItemBuilder lore(String... lore) {
        this.lore = Arrays.asList(lore);
        return this;
    }

    public ItemBuilder shiny(boolean shiny) {
        this.shiny = shiny;
        return this;
    }

    public ItemStack build() {
        ItemStack stack = new ItemStack(material);
        stack.setAmount(amount);
        stack.editMeta(m -> {
            m.displayName(Component.text(name));
            m.setLore(lore);
        });

        return stack;
    }

}
