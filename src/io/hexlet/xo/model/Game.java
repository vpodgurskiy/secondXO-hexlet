package io.hexlet.xo.model;

public class Game<T> {

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
}
