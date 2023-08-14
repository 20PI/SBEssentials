package pye.twenty.sbessentials.command;

import lombok.Getter;
import org.bukkit.command.CommandSender;

@Getter
public abstract class SubCommand {

    private final String command;
    private final int requiredArgs;

    public SubCommand(String command, int requiredArgs) {
        this.command = command;
        this.requiredArgs = requiredArgs;
    }

    public abstract boolean execute(CommandSender sender, String[] args);

    public boolean canExecute(String[] args) {
        return args.length >= 1 + requiredArgs;
    }
}
