package statistics.matcher;

import statistics.Player;

public class All implements Matcher {

    public All(Matcher matcher) {
    }

    @Override
    public boolean matches(Player p) {
        return true;
    }
}
