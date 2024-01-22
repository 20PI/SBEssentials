package pye.twenty.sbessentials.util;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class StringUtils {

    public static String capitalizeWord(String str){
        String[] words =str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }


    public static String getName(ItemStack stack) {
        ItemMeta meta = stack.getItemMeta();
        stack.setItemMeta(meta);
        return stack.getItemMeta().hasDisplayName() ? meta.getDisplayName() : capitalizeWord(stack.getType().name().replace("_", " ").toLowerCase());
    }

    public static String formatSeconds(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        String formattedTime = "";

        if (minutes > 0) {
            formattedTime += String.format("%02dm ", minutes);
        }

        formattedTime += String.format("%02ds", remainingSeconds);

        return formattedTime;
    }

}
