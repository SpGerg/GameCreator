package org.spgerg.gamecreator.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.spgerg.gamecreator.Main;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        if (sender instanceof ConsoleCommandSender) {
            Main.instance.getLogger().info("The game creator commands must be used by player.");

            return true;
        }

        Player player = (Player) sender;

        for (Subcommand subcommand : Subcommand.subcommands) {
            if (subcommand.getName().equals(args[0])) {
                return subcommand.execute(sender, args);
            }
        }

        player.sendMessage("Command " + args[0] + " not be found.");

        return true;
    }
}
