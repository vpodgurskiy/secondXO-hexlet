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
    public void getFigure() {

        final Field field = new Field(3);

        final Point point = new Point(0,0);

        field.setFigure(point, Figure.X);

        assertEquals(Figure.X, field.getFigure(point));

    }
}