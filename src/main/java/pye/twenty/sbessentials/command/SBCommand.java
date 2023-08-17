package pye.twenty.sbessentials.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public abstract class SBCommand implements CommandExecutor, TabCompleter {

    private final Map<String, SubCommand> commands = new HashMap<>();

    protected SBCommand() {

    }

    protected SBCommand(SubCommand... subCommands) {
        for (SubCommand command : subCommands) {
            commands.put(command.getCommand(), command);
        }
    }

    public abstract void execute(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String[] args);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commands.isEmpty()) {
            execute(sender, command, s, args);
            return false;
        }

        if (args.length != 0) {
            String argument = args[0].toLowerCase();
            if (commands.containsKey(argument)) {
                SubCommand sub = commands.get(argument);
                if (sub.canExecute(args)) {
                    sub.execute(sender, Arrays.copyOfRange(args, 1, args.length));
                    return false;
                }
            }
        }


        execute(sender, command, s, args);
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 1) {
            return new ArrayList<>(commands.keySet());
        }
        return null;
    }
}
