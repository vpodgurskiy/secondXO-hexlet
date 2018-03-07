package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerWhenWinnerRow() throws AlreadyOccupiedException, InvalidPointException {

        final WinnerController winnerController = new WinnerController();

        final MoveController moveController = new MoveController();

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Figure inputValue = Figure.X;

        final Figure expectedValue = Figure.X;

        for (int i = 0; i < field.getSize(); i++) {

            moveController.applyFigure(field, inputValue, new Point(0, i));
            moveController.applyFigure(field, inputValue, new Point(1, i));
            moveController.applyFigure(field, inputValue, new Point(2, i));

            final Figure actualValue = winnerController.getWinner(field);

            assertEquals(expectedValue, actualValue);
        }


    }

    @Test
    public void getWinnerWhenWinnerColumn() throws AlreadyOccupiedException, InvalidPointException {

        final WinnerController winnerController = new WinnerController();

        final MoveController moveController = new MoveController();

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Figure inputValue = Figure.O;

        final Figure expectedValue = Figure.O;

        for (int i = 0; i < field.getSize(); i++) {

            moveController.applyFigure(field, inputValue, new Point(i, 0));
            moveController.applyFigure(field, inputValue, new Point(i, 1));
            moveController.applyFigure(field, inputValue, new Point(i, 2));

            final Figure actualValue = winnerController.getWinner(field);

            assertEquals(expectedValue, actualValue);
        }

    }

    @Test
    public void getWinnerWhenWinnerDiagonal() throws AlreadyOccupiedException, InvalidPointException {

        final WinnerController winnerController = new WinnerController();

        final MoveController moveController = new MoveController();

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Figure inputValue = Figure.O;

        moveController.applyFigure(field, inputValue, new Point(0, 0));
        moveController.applyFigure(field, inputValue, new Point(1, 1));
        moveController.applyFigure(field, inputValue, new Point(2, 2));

        final Figure expectedValue = Figure.O;

        final Figure actualValue = winnerController.getWinner(field);

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void getWinnerWhenNowWinner() throws AlreadyOccupiedException, InvalidPointException {

        final WinnerController winnerController = new WinnerController();

        final MoveController moveController = new MoveController();

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Figure inputValue = Figure.O;

        moveController.applyFigure(field, inputValue, new Point(2, 0));
        moveController.applyFigure(field, inputValue, new Point(1, 1));
        moveController.applyFigure(field, inputValue, new Point(2, 2));

        final Figure actualValue = winnerController.getWinner(field);

        assertNull(actualValue);

    }

}