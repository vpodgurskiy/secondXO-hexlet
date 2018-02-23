package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    void applyFigure(final Field field, final Figure figure, final Point point)
                    throws AlreadyOccupiedException, InvalidPointException {

        field.setFigure(point, figure);

    }
}
