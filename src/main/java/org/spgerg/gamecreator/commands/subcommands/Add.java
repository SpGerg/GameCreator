package org.spgerg.gamecreator.commands.subcommands;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.spgerg.gamecreator.commands.Subcommand;
import org.spgerg.gamecreator.files.Files;
import org.spgerg.gamecreator.files.serializables.ProgramSerializable;
import org.spgerg.gamecreator.files.serializables.ScriptSerializable;

public class Add extends Subcommand {
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public boolean execute(CommandSender sender, String[] arguments) {
        if (arguments.length < 3) { return false; }

        Player player = (Player) sender;
        World world = player.getWorld();

        ProgramSerializable program = Files.instance.getProgram(arguments[2], world);

        if (program == null) {
            player.sendMessage("Program with " + arguments[2] + " don't be found!");

            return true;
        }

        Files.instance.addScript(new ScriptSerializable(arguments[1], program, null), world);

        return true;
    }
}
