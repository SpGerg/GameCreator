package org.spgerg.gamecreator.files;

import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.spgerg.gamecreator.Main;
import org.spgerg.gamecreator.files.serializables.ProgramSerializable;
import org.spgerg.gamecreator.files.serializables.ScriptSerializable;
import org.spgerg.gamecreator.language.programs.Program;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Files {

    public File programsFile;
    public FileConfiguration programsConfiguration;

    public static Files instance = new Files();

    public Files() {
        programsFile = new File(Main.instance.getDataFolder() + File.separator + "programs.yml");

        programsConfiguration = YamlConfiguration.loadConfiguration(programsFile);
    }

    public boolean isProgramExistsWithName(String name, World world) {
        ConfigurationSection section = programsConfiguration.getConfigurationSection(world.getName());

        Set<String> keys;

        if (section != null) {
            keys = section.getKeys(false);

            for (String key : keys) {
                if(programsConfiguration.getSerializable(getProgramPath(name, world.getName()), ProgramSerializable.class).name.equals(name)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void addProgram(ProgramSerializable program, World world) {
        ConfigurationSection section = programsConfiguration.getConfigurationSection(world.getName());

        List<ProgramSerializable> programsList = new ArrayList<>();

        Set<String> keys;

        if (section != null) {
            keys = section.getKeys(false);

            for (String key : keys) {
                programsList.add(programsConfiguration.getSerializable(getProgramPath(key, world.getName()), ProgramSerializable.class));
            }
        }

        programsList.add(program);

        programsConfiguration.set(getProgramPath(program.name, world.getName()), programsList);

        try {
            programsConfiguration.save(programsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProgramSerializable getProgram(String name, World world) {
        return programsConfiguration.getSerializable(getProgramPath(name, world.getName()), ProgramSerializable.class);
    }

    public void addScript(ScriptSerializable script, World world) {
        ProgramSerializable program = getProgram(script.program.name, world);

        if (program == null) {
            throw new IllegalArgumentException(script.program.name);
        }

        program.scripts.add(script);

        programsConfiguration.set(getProgramPath(script.program.name, world.getName()), program);

        try {
            programsConfiguration.save(programsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getProgramPath(String name, String world_name) {
        return world_name + ".programs." + name;
    }
}
