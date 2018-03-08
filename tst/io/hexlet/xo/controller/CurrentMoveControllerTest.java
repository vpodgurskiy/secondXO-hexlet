package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMove() throws AlreadyOccupiedException, InvalidPointException {

        final MoveController moveController = new MoveController();

        final CurrentMoveController currentMoveController = new CurrentMoveController();

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        //1
        checkMoveController(currentMoveController, moveController, field, Figure.X, new Point(0, 0), Figure.O);

        //2
        checkMoveController(currentMoveController, moveController, field, Figure.O, new Point(1, 1), Figure.X);

        //3
        checkMoveController(currentMoveController, moveController, field, Figure.X, new Point(0, 2), Figure.O);

    }

    private void checkMoveController (CurrentMoveController currentMoveController, MoveController moveController,
                                      Field field, Figure figure, Point point, Figure expectedValue)
                                      throws AlreadyOccupiedException, InvalidPointException {

        moveController.applyFigure(field, figure, point);

        final Figure actualValue = currentMoveController.currentMove(field);

        assertEquals(expectedValue, actualValue);
    }
}