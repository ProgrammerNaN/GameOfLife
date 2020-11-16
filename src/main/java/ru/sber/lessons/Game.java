package ru.sber.lessons;

import java.util.Random;

public class Game {

    private static final int MIN_STATE = 0;
    private static final int MAX_STATE = 2;

    private int width;
    private int height;
    private int[][] board;

    public int[][] getBoard() {
        return this.board;
    }

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[height][width];
        initBoard();
    }

    public Game(int[][] board) {
        this.board = board;
        this.width = board[0].length;
        this.height = board.length;
    }

    private void initBoard() {
        Random random = new Random();
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.board[y][x] = random.ints(MIN_STATE, MAX_STATE).findFirst().getAsInt();
            }
        }
    }

    public int isAlive(int x, int y) {

        if (x < 0 || x > this.width - 1) {
            return 0;
        }

        if (y < 0 || y > this.height - 1) {
            return 0;
        }

        return this.board[y][x];
    }

    public int getCountNeighbor(int x, int y) {
        int count = 0;

        count += isAlive(x - 1, y - 1);
        count += isAlive(x, y - 1);
        count += isAlive(x + 1, y - 1);

        count += isAlive(x - 1, y);
        count += isAlive(x + 1, y);

        count += isAlive(x - 1, y + 1);
        count += isAlive(x , y + 1);
        count += isAlive(x + 1, y + 1);

        return count;
    }

    public void step() {
        int[][] newBoard = new int[height][width];
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                int countNeighbor = getCountNeighbor(x, y);
                if (isAlive(x, y) == 1) {
                    if (countNeighbor < 2) {
                        newBoard[y][x] = 0;
                    } else if (countNeighbor == 2 || countNeighbor == 3) {
                        newBoard[y][x] = 1;
                    } else {
                        newBoard[y][x] = 0;
                    }
                } else {
                    if (countNeighbor == 3) {
                        newBoard[y][x] = 1;
                    }
                }
            }
        }
        this.board = newBoard;
    }
}
