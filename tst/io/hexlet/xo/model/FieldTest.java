package io.hexlet.xo.model;

import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {

        final Field field = new Field(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() {

        final Field field = new Field(3);

        final Point inputPoint = new Point(0,0);

        final Figure inputFigure = Figure.X;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);

    }

}