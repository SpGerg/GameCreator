package org.spgerg.gamecreator.files.serializables;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramSerializable implements ConfigurationSerializable {

    public final String name;

    public List<ScriptSerializable> scripts;

    public ProgramSerializable(String name, List<ScriptSerializable> scripts) {
        this.name = name;
        this.scripts = scripts;

        if (scripts == null) {
            scripts = new ArrayList<>();
        }
    }

    public static ProgramSerializable deserialize(Map<String, Object> args) {
        List<ScriptSerializable> list = (List<ScriptSerializable>) args.get("scripts");

        if (list == null) {
            list = new ArrayList<>();
        }

        return new ProgramSerializable((String) args.get("name"), list);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("scripts", scripts);

        return map;
    }
}
