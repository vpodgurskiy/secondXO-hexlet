package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        assertEquals(FIELD_SIZE, field.getSize());
    }

    @Test
    public void setFigure() throws InvalidPointException, AlreadyOccupiedException {

        final int FIELD_SIZE = 3;

        final Field<Figure> field = new Field(FIELD_SIZE);

        final Point inputPoint = new Point(0,0);

        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);

    }

    @Test
    public void getFigureWhenXLessThenZero() {

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Point inputPoint = new Point(-1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYLessThenZero() {

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Point inputPoint = new Point(0,-1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenXMoreThenSize() {

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Point inputPoint = new Point(FIELD_SIZE + 1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYMoreThenSize() {

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Point inputPoint = new Point(0,FIELD_SIZE + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenFigureIsNotEmpty() throws AlreadyOccupiedException, InvalidPointException {

        final int FIELD_SIZE = 3;

        final Field field = new Field(FIELD_SIZE);

        final Point inputPoint = new Point(0,0);

        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint, inputFigure);

        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final AlreadyOccupiedException e) {}
    }
}