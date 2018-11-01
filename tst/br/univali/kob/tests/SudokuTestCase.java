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
        System.out.println(gameTable.tableToString(AppConfig.BASE_MATRIX));
    }

    public void runSudokuTestCase() {
        SudokuGenerator sudokuGenerator = new SudokuGenerator(GameDifficulty.HARD);
        System.out.println("GAME TABLE: \n" + sudokuGenerator.getGameTable().tableToString(
                sudokuGenerator.getGameTable().getTable()));
        System.out.println("CORRECT TABLE: \n" + sudokuGenerator.getGameTable().tableToString(
                sudokuGenerator.getGameTable().getCorrectTable()));
    }

    public void runSudokuApplicationViewTestCase() {
        SudokuApplicationView sudokuApplicationView = new SudokuApplicationView();
        sudokuApplicationView.placeMatrixCell();
        System.out.println("GAME TABLE: ");
        System.out.println(sudokuApplicationView.getSudokuGenerator().getGameTable()
                .tableToString(sudokuApplicationView.getSudokuGenerator().getGameTable().getTable()));
    }

    public static void main (String[] args) {
        SudokuTestCase sudokuTestCase = new SudokuTestCase();
        // sudokuTestCase.runMatrixTest();
        // sudokuTestCase.runBaseMatrixTest();
        // sudokuTestCase.runGameTableTestCase();
        // sudokuTestCase.runSudokuTestCase();
        sudokuTestCase.runSudokuApplicationViewTestCase();
    }
}
