package io.hexlet.xo.model;

public class Player {

    private final String name;

    private final Figure figure;

    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    final String getName() {

        return name;
    }

    final Figure getFigure() {

        return figure;
    }
}
