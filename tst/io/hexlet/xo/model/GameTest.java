package io.hexlet.xo.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getPlayers() {
    }

    @Test
    public void getField() {

        final Field<Field> field = new Field(3);

        final Game<Game> game = new Game(null, null, field);

        assertEquals(field, game.getField());

    }

    @Test
    public void getName() {

        final String name = "XO";

        final Game<Game> game = new Game(name, null, null);

        assertEquals(name, game.getName());

    }
}