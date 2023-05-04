package org.spgerg.gamecreator;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;
import org.spgerg.gamecreator.commands.Commands;
import org.spgerg.gamecreator.files.serializables.*;

public final class Main extends JavaPlugin {

    static {
        ConfigurationSerialization.registerClass(ActionSerializable.class);
        ConfigurationSerialization.registerClass(ComponentSerializable.class);
        ConfigurationSerialization.registerClass(ProgramSerializable.class);
        ConfigurationSerialization.registerClass(ScriptSerializable.class);
        ConfigurationSerialization.registerClass(VariableSerializable.class);
    }

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("gamecreator").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
