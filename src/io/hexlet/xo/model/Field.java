package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private final int MIN_COORDINATE = 0;

    private final int MAX_COORDINATE;

    private final Figure[][] field;

    public Field(final int FIELD_SIZE) {
        this.MAX_COORDINATE = FIELD_SIZE;
        this.field = new Figure[FIELD_SIZE][FIELD_SIZE];

    }

    public int getSize() {
        return field.length;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {

        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException,
                                                                         AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        if (getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }


}
