package br.univali.kob.model;

import br.univali.kob.model.helpers.Console;

public class SudokuApplicationView {
    private Sudoku sudoku;
    private Console console;

    public SudokuApplicationView(GameDifficulty gameDifficulty) {
        this.sudoku = new Sudoku(gameDifficulty);
    }

    public void placeMatrixCell(MatrixCell matrixCell) {

    }
}
