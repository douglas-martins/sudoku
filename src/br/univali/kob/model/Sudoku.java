package br.univali.kob.model;

public class Sudoku {
    private SudokuApplicationView sudokuApplicationView;

    public void runGameSession() {
        while (!sudokuApplicationView.getSudokuGame().isGameOver()) {
            sudokuApplicationView.askForPlay();
        }
    }
}
