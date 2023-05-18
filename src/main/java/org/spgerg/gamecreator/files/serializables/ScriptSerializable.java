package org.spgerg.gamecreator.files.serializables;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.spgerg.gamecreator.language.components.Component;
import org.spgerg.gamecreator.language.programs.Program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptSerializable implements ConfigurationSerializable {

    public final String name;

    public final ProgramSerializable program;

    public final List<Component> components;

    public ScriptSerializable(String name, ProgramSerializable program, List<Component> components) {
        this.name = name;
        this.program = program;
        this.components = components;

        if (components == null) {
            components = new ArrayList<>();
        }
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("program", program.name);
        map.put("components", components);

        return map;
    }
}
