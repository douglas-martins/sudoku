package br.univali.kob.model;

public class MainGame {
    private static Sudoku sudoku;

    public static void main(String[] args) {
        sudoku = new Sudoku();
        sudoku.runGameSession();
    }
}
