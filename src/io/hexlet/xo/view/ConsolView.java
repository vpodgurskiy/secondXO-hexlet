package io.hexlet.xo.view;

import io.hexlet.xo.controller.CurrentMoveController;
import io.hexlet.xo.controller.MoveController;
import io.hexlet.xo.controller.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolView {

    public final void show(final Game game) {

        final Field field = game.getField();

        System.out.format("Game name: %s\n", game.getName());

        for (int i = 0; i < field.getSize(); i++) {
            if (i != 0) {
                printSeparator();
            }
            printLine(field, i);
        }
    }

    public boolean move(final Game game) {

        final Field field = game.getField();

        final CurrentMoveController currentMoveController = new CurrentMoveController();

        final WinnerController winnerController = new WinnerController();

        final MoveController moveController = new MoveController();

        Figure winnerFigure = winnerController.getWinner(field);
        if (winnerFigure != null) {
            System.out.format("The winner is: %s\n", winnerFigure);
            return false;
        }

        Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("Now winner");
            return false;
        }

        System.out.format("Please input point for %s\n", currentFigure);
        final Point point = askPoint();

        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (final AlreadyOccupiedException | InvalidPointException e) {
            System.out.println("Point is invalid!");
        }
        return true;

    }

    private Point askPoint() {
        return new Point(askCoordinate("x"), askCoordinate("y"));
    }

    private int askCoordinate(final String coordinate) {
        System.out.format("Please input coordinate %s :_", coordinate);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        }catch (final InputMismatchException e) {
            return askCoordinate(coordinate);
        }
    }

    private void printLine(final Field field, final int i) {

        for (int j = 0; j < field.getSize(); j++) {
            if (j != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(i, j));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("-----------");
    }
}
