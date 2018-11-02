package br.univali.kob.model;

import br.univali.kob.model.sudoku.Sudoku;

public class MainGame {
    private static Sudoku sudoku;

    public static void main(String[] args) {
        sudoku = new Sudoku();
        sudoku.runGameSession();
    }
}
