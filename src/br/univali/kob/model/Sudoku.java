package br.univali.kob.model;

/** Representa o game com I/O e as regras.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public class Sudoku {
    /**
     *
     */
    private SudokuApplicationView sudokuApplicationView;

    public void runGameSession() {
        while (!sudokuApplicationView.getSudokuGame().isGameOver()) {
            sudokuApplicationView.askForPlay();
        }
    }
}
