package org.spgerg.gamecreator.language.programs;

import org.spgerg.gamecreator.language.scripts.Script;

import java.util.List;

public class Program {

    public String name;
    public List<Script> scripts;

    public void run() {
        for (Script script : scripts) {
            script.execute();
        }
    }
}
