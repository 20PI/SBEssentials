package pye.twenty.sbessentials.command.impl;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import pye.twenty.sbessentials.command.Command;
import pye.twenty.sbessentials.command.SubCommand;

public class TestCommand extends Command {

    public TestCommand() {
        super(new SubCommand("wow", 0) {
            @Override
            public boolean execute(CommandSender sender, String[] args) {
                sender.sendMessage("wow indeed");
                return false;
            }
        });
    }

    @Override
    public void execute(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String[] args) {
        sender.sendMessage("WTF");
    }


}
