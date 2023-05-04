package org.spgerg.gamecreator.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.spgerg.gamecreator.commands.Subcommand;
import org.spgerg.gamecreator.files.Files;
import org.spgerg.gamecreator.files.serializables.ProgramSerializable;

public class Create extends Subcommand {

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public boolean execute(CommandSender sender, String[] arguments) {
        if (arguments.length < 2) {
            return false;
        }

        Player player = (Player) sender;

        Files.instance.addProgram(new ProgramSerializable(arguments[1], null), player.getWorld());

        return false;
    }
}
