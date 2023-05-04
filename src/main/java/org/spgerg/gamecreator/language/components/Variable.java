package org.spgerg.gamecreator.language.components;

public abstract class Variable implements Component {

    public final VariableType type;

    public Object data;

    public Variable(VariableType type, Object data) {
        this.type = type;
        this.data = data;
    }
}
