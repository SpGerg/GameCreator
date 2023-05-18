package org.spgerg.gamecreator.language;

import org.apache.commons.lang.NullArgumentException;
import org.bukkit.entity.Player;
import org.spgerg.gamecreator.language.components.Action;

import java.util.HashMap;
import java.util.function.Consumer;

public class Functions {

    public static HashMap<String, Consumer<Action>> functions = new HashMap<>();

    static {
        functions.put("sendMessage", Functions::sendMessage);
    }

    public static void sendMessage(Action action) {
        Object varData = action.data.get(0).data;
        Object message = action.data.get(1).data;

        if (varData instanceof Player) {
            Player player = (Player) varData;

            if (message == null && !(message instanceof String)) {
                throw new NullArgumentException(action.name);
            }

            player.sendMessage((String) message);

            return;
        }

        throw new NullArgumentException(action.name);
    }

}
