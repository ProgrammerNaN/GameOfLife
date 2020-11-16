package ru.sber.lessons;

import java.io.IOException;

public class MainController {

    private static final int WIDTH = 15;
    private static final int HEIGHT = 10;

    private static final int[][] BOARD = {
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0}
    };

    private View view;
    private Game game;

    public MainController(View view, Game game) {
        this.view = view;
        this.game = game;
    }

    public static void main(String[] args) {
        Game game = new Game(WIDTH, HEIGHT);
        View view = new ConsoleView();

        MainController controller = new MainController(view, game);
        controller.start();
    }

    public void start() {
        while (true) {
            try {
                this.game.step();
                view.showBoard(this.game.getBoard());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
