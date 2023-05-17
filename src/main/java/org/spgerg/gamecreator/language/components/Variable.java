package org.spgerg.gamecreator.language.components;

public abstract class Variable extends Component {

    public final String name;

    public final VariableType type;

    public Object data;

    public Variable(String name, VariableType type, Object data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    @Override
    public String getComponentName() {
        return "ACTION";
    }
}
