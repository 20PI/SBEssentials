package pye.twenty.sbessentials.command.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pye.twenty.sbessentials.SBEssentials;
import pye.twenty.sbessentials.command.SBCommand;
import pye.twenty.sbessentials.gui.impl.TestGUI;

public class TestCommand extends SBCommand {

    @Override
    public void execute(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player player) {
            SBEssentials.openGUI(player, new TestGUI());
        }
    }

}
