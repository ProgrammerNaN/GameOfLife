package ru.sber.lessons;

import java.io.Console;
import java.io.IOException;

public class ConsoleView implements View {

    public ConsoleView() {

    }

    public void showBoard(int[][] board) {
        StringBuilder stringBuilder = new StringBuilder(getLine(board[0].length));
        for (int y = 0; y < board.length; y++) {
            stringBuilder.append("|");
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == 1) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(".");
                }
            }
            stringBuilder.append("|\n");
        }
        stringBuilder.append(getLine(board[0].length));
        System.out.println(stringBuilder.toString());
    }

    private String getLine(int width) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < width + 2; x++) {
            stringBuilder.append("-");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

}
