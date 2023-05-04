package org.spgerg.gamecreator.language.scripts;

import org.spgerg.gamecreator.Main;
import org.spgerg.gamecreator.language.components.Component;
import org.spgerg.gamecreator.language.programs.Program;
import org.spgerg.gamecreator.language.components.Action;

import java.util.ArrayList;
import java.util.List;

public class Script {

    public final String name;

    public final Program program;

    public List<Component> components = new ArrayList<>();

    public Script(String name, Program program) {
        this.name = name;
        this.program = program;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public boolean execute() {
        for (Component component : components) {
            if (component instanceof Action && !((Action) component).execute()) {
                Main.instance.getLogger().info("[ERROR] In script " + name + " was found error. Script executing was stopped.");

                return false;
            }
        }

        return true;
    }
}
