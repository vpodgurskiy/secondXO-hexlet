package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner (final Field field) throws InvalidPointException {

        int size = field.getSize();

        Figure figure = Figure.X;

        if (checkFigure(figure, size, field) == Figure.X) {
            return figure;
        }

        figure = Figure.O;
        if (checkFigure(figure, size, field) == Figure.O) {
            return figure;
        }

        return null;
    }

    private Figure checkFigure(final Figure figure, final int size, final Field field) throws InvalidPointException {
        if (checkLine(figure, size, field) == figure || checkColumn(figure, size, field) == figure
                || checkDiagonal1(figure, size, field) == figure || checkDiagonal2(figure, size, field) == figure) {
            return figure;
        }

        return null;
    }

    private Figure checkColumn(final Figure figure, final int size, final Field field) throws InvalidPointException {

        for (int x = 0; x < size; x++) {
            int count = 0;
            for (int y = 0; y < size; y++) {
                if(field.getFigure(new Point(y,x)) == figure) {
                    count++;
                }
            }
            if (count == size) {
                return figure;
            }
        }

        return null;
    }

    private Figure checkLine(final Figure figure, final int size, final Field field) throws InvalidPointException {

        for (int x = 0; x < size; x++) {
            int count = 0;
            for (int y = 0; y < size; y++) {
                if(field.getFigure(new Point(x,y)) == figure) {
                    count++;
                }
            }
            if (count == size) {
                return figure;
            }
        }

        return null;
    }

    private Figure checkDiagonal1 (final Figure figure, final int size, final Field field) throws InvalidPointException {

        int count = 0;

        for (int y = 0; y < size; y++) {
            if(field.getFigure(new Point(y,y)) == figure) {
                count++;
            }
        }

        if (count == size) {
            return figure;
        }

        return null;

    }

    private Figure checkDiagonal2 (final Figure figure, final int size, final Field field) throws InvalidPointException {

        int count = 0;

        int x = 0;
        int y = size - 1;

        for (int i = 0; i < size; i++) {
            if(field.getFigure(new Point(x,y)) == figure) {
                count++;
            }

            x++;
            y--;
        }

        if (count == size) {
            return figure;
        }

        return null;
    }

}
