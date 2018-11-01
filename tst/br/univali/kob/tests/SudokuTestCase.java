package br.univali.kob.tests;

import br.univali.kob.model.*;


public class SudokuTestCase {
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
        GameTable gameTable = new GameTable(GameDifficulty.HARD);
        System.out.println(gameTable.tableToString(gameTable.getTable()));
        System.out.println("BASE MATRIX: ");
        System.out.println(GameTable.tableToString(AppConfig.BASE_MATRIX));
    }

    public void runSudokuTestCase() {
//        System.out.println(GameTable.tableToString(AppConfig.BASE_MATRIX));
        Sudoku sudoku = new Sudoku(GameDifficulty.HARD);
//        System.out.println("GAME TABLE: \n" + sudoku.getGameTable().tableToString(sudoku.getGameTable().getTable()));
//        System.out.println("BASE MATRIX: ");
        System.out.println(GameTable.tableToString(AppConfig.BASE_MATRIX));
    }

    public static void main (String[] args) {
        SudokuTestCase sudokuTestCase = new SudokuTestCase();
        //sudokuTestCase.runMatrixTest();
        //sudokuTestCase.runBaseMatrixTest();
        //sudokuTestCase.runGameTableTestCase();
        sudokuTestCase.runSudokuTestCase();
    }
}
