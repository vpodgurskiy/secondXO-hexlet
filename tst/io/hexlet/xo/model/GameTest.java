package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getPlayers() {
    }

    @Test
    public void getField() {

        final Field field = new Field(3);

        final Game game = new Game(null, null, field);

        assertEquals(field, game.getField(game));

    }

    @Test
    public void getName() {

        final String name = "XO";

        final Game game = new Game(name, null, null);

        assertEquals(name, game.getName(game));

    }
}