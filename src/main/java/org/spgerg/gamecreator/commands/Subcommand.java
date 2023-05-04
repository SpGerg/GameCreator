package org.spgerg.gamecreator.commands;

import org.bukkit.command.CommandSender;
import org.spgerg.gamecreator.commands.subcommands.Add;
import org.spgerg.gamecreator.commands.subcommands.Create;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public abstract class Subcommand {

    public static final Collection<Subcommand> subcommands = Collections.unmodifiableCollection(Arrays.asList(new Create(), new Add()));

    public abstract String getName();

    public abstract boolean execute(CommandSender sender, String[] arguments);
}
