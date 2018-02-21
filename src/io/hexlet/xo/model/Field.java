package io.hexlet.xo.model;

public class Field {

    private final Figure[][] field;

    Field(int size) {
        this.field = new Figure[size][size];

    }

    int getSize() {

        return field.length;

    }

    void setFigure(final Point point, final Figure figure) {
        field[point.x][point.y] = figure;

    }

    Figure getFigure(final Point point) {

        return field[point.x][point.y];

    }
}
