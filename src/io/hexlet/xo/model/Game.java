package io.hexlet.xo.model;

public class Game {

    private final String name;

    private final Player player;

    private final Field field;

    Game(final String name, final Player player, final Field field) {

        this.name = name;
        this.player = player;
        this.field = field;

    }

    final Player[] getPlayers(final Game game) {

        return null;

    }

    final Field getField(final Game game) {

        return game.field;

    }

    final String getName(final Game game) {

        return game.name;

    }
}
