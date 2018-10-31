package br.univali.kob.tests;

import br.univali.kob.model.*;


public class GenerateMatrixTest {
    public void runMatrixTest () {
        Matrix matrix = new Matrix(MatrixPosition.ONE);
        System.out.println(matrix.toString());
    }

    public void runBaseMatrixTest () {
        for (int i = 0; i < 9; i++) {
            System.out.println(AppConfig.BASE_MATRIX.get(i).toString());
        }
    }

    public void runGameTableTest () {
        GameTable gameTable = new GameTable(GameDifficulty.EASY);
        System.out.println(gameTable.tableToString(gameTable.getTable()));
    }

    public static void main (String[] args) {
        GenerateMatrixTest generateMatrixTest = new GenerateMatrixTest();
        //generateMatrixTest.runMatrixTest();
        //generateMatrixTest.runBaseMatrixTest();
        generateMatrixTest.runGameTableTest();
    }
}
