package io.hexlet.xo.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Game<T> implements Iterable<Player> {

    private final String name;

    private final Player[] players;

    private final Field<T> field;

    public Game(final String name, final Player[] players, final Field<T> field) {

        this.name = name;
        this.players = players;
        this.field = field;

    }

    public final Player[] getPlayers() {

        return players;

    }

    public final Field<T> getField() {

        return field;

    }

    public final String getName() {

        return name;

    }

    @Override
    public Iterator<Player> iterator() {
        final List<Player> playersList = Arrays.asList(players);
        return playersList.iterator();
    }
}
