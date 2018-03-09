
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsolView;

public class Main {
    public static void main(final String[] args) {

        final ConsolView consolView = new ConsolView();

        final Field field = new Field(3);

        final Player[] players = consolView.createPlayers();

        final Game game = new Game("XO", players, field);

        consolView.show(game);

        while (consolView.move(game)) {
            consolView.show(game);
        }


    }
}


