package br.univali.kob.tests;

import br.univali.kob.model.*;
import br.univali.kob.model.matrix.Matrix;
import br.univali.kob.model.matrix.MatrixPosition;
import br.univali.kob.model.sudoku.GameDifficulty;
import br.univali.kob.model.sudoku.SudokuApplicationView;
import br.univali.kob.model.sudoku.SudokuGame;
import br.univali.kob.model.sudoku.SudokuGenerator;

/**
 * Representa os testes para validar as classes que forma o Sudoku.
 */
public class SudokuClassesTestCase {
    /**
     * Roda os testes para a classe Matrix.
     */
    public void runMatrixTestCase() {
        Matrix matrix = new Matrix(MatrixPosition.ONE);
        System.out.println(matrix.toString());
    }

    /**
     * Roda os testes para a matriz base, que se encontra em AppConfig.
     */
    public void runBaseMatrixTestCase() {
        for (int i = 0; i < 9; i++) {
            System.out.println(AppConfig.BASE_MATRIX.get(i).toString());
        }
    }

    /**
     * Roda os testes para classe SudokuGenerator
     */
    public void runSudokuGeneratorTestCase() {
        SudokuGenerator sudokuGenerator = new SudokuGenerator(GameDifficulty.HARD);
        System.out.println(sudokuGenerator.tableToString(sudokuGenerator.getTable()));
        System.out.println("BASE MATRIX: ");
        System.out.println(sudokuGenerator.tableToString(AppConfig.BASE_MATRIX));
    }

    /**
     * Roda os testes para a classe Sudoku.
     */
    public void runSudokuTestCase() {
        SudokuGame sudokuGame = new SudokuGame(GameDifficulty.HARD);
        System.out.println("GAME TABLE: \n" + sudokuGame.getSudoku().tableToString(
                sudokuGame.getSudoku().getTable()));
        System.out.println("CORRECT TABLE: \n" + sudokuGame.getSudoku().tableToString(
                sudokuGame.getSudoku().getCorrectTable()));
    }

    /**
     * Roda os testes para a classe SudokuApplicationView.
     */
    public void runSudokuApplicationViewTestCase() {
        SudokuApplicationView sudokuApplicationView = new SudokuApplicationView();
        sudokuApplicationView.askForPlay();
        System.out.println("GAME TABLE: ");
        System.out.println(sudokuApplicationView.getSudokuGame().getSudoku()
                .tableToString(sudokuApplicationView.getSudokuGame().getSudoku().getTable()));
    }

    /**
     * Main function para rodar os testes.
     * @param args String[] com valores de argumentos para o programa utilizar quando for executado.
     */
    public static void main (String[] args) {
        SudokuClassesTestCase sudokuClassesTestCase = new SudokuClassesTestCase();
        // sudokuClassesTestCase.runMatrixTest();
        // sudokuClassesTestCase.runBaseMatrixTest();
        // sudokuClassesTestCase.runSudokuGeneratorTestCase();
        // sudokuClassesTestCase.runSudokuTestCase();
        // sudokuClassesTestCase.runSudokuApplicationViewTestCase();
    }
}
