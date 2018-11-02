package br.univali.kob.model.sudoku;

import br.univali.kob.model.AppConfig;

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

    public Sudoku() {
        initGame();
    }

    public void initGame() {
        System.out.println("##################################################");
        System.out.println("#                 " + AppConfig.APP_NAME + "                         #");
        System.out.println("#                 " + AppConfig.APP_VERSION + "                          #");
        System.out.println("##################################################");
        System.out.println();
        sudokuApplicationView = new SudokuApplicationView();
    }

    public void runGameSession() {
        while (!sudokuApplicationView.getSudokuGame().isGameOver()) {
            sudokuApplicationView.askForPlay();
        }
    }
}
