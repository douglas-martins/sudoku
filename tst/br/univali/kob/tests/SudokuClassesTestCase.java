package br.univali.kob.tests;

import br.univali.kob.model.*;
import br.univali.kob.model.matrix.Matrix;
import br.univali.kob.model.matrix.MatrixPosition;
import br.univali.kob.model.sudoku.SudokuApplicationView;
import br.univali.kob.model.sudoku.SudokuGame;
import br.univali.kob.model.sudoku.SudokuGenerator;


public class SudokuClassesTestCase {
    public void runMatrixTestCase() {
        Matrix matrix = new Matrix(MatrixPosition.ONE);
        System.out.println(matrix.toString());
    }

    public void runBaseMatrixTestCase() {
        for (int i = 0; i < 9; i++) {
            System.out.println(AppConfig.BASE_MATRIX.get(i).toString());
        }
    }

    public void runGameTableTestCase() {
        SudokuGenerator sudokuGenerator = new SudokuGenerator(GameDifficulty.HARD);
        System.out.println(sudokuGenerator.tableToString(sudokuGenerator.getTable()));
        System.out.println("BASE MATRIX: ");
        System.out.println(sudokuGenerator.tableToString(AppConfig.BASE_MATRIX));
    }

    public void runSudokuTestCase() {
        SudokuGame sudokuGame = new SudokuGame(GameDifficulty.HARD);
        System.out.println("GAME TABLE: \n" + sudokuGame.getSudoku().tableToString(
                sudokuGame.getSudoku().getTable()));
        System.out.println("CORRECT TABLE: \n" + sudokuGame.getSudoku().tableToString(
                sudokuGame.getSudoku().getCorrectTable()));
    }

    public void runSudokuApplicationViewTestCase() {
        SudokuApplicationView sudokuApplicationView = new SudokuApplicationView();
        sudokuApplicationView.askForPlay();
        System.out.println("GAME TABLE: ");
        System.out.println(sudokuApplicationView.getSudokuGame().getSudoku()
                .tableToString(sudokuApplicationView.getSudokuGame().getSudoku().getTable()));
    }

    public static void main (String[] args) {
        SudokuClassesTestCase sudokuClassesTestCase = new SudokuClassesTestCase();
        // sudokuClassesTestCase.runMatrixTest();
        // sudokuClassesTestCase.runBaseMatrixTest();
        // sudokuClassesTestCase.runGameTableTestCase();
        // sudokuClassesTestCase.runSudokuTestCase();
        // sudokuClassesTestCase.runSudokuApplicationViewTestCase();
    }
}
