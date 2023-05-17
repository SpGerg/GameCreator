package org.spgerg.gamecreator.language.components;

import org.apache.commons.lang.NullArgumentException;
import org.spgerg.gamecreator.Main;
import org.spgerg.gamecreator.language.Functions;
import org.spgerg.gamecreator.language.scripts.Script;

import java.util.List;

public abstract class Action extends Component {

    public final String name;

    public final Script script;

    //It is like arguments
    public final List<Variable> data;

    public final String function;

    public Action(String name, Script script, List<Variable> data, String function) {
        this.name = name;
        this.script = script;
        this.data = data;
        this.function = function;
    }

    public boolean execute() {
        try {
            Functions.functions.get(function).accept(this);
        }
        catch (NullArgumentException | NullPointerException exception){
            Main.instance.getLogger().info("[ERROR] In action " + name + " was found error. Action and script " + script.name + " executing was stopped.");

            return false;
        }

        return true;
    }

    @Override
    public String getComponentName() {
        return "ACTION";
    }
}
