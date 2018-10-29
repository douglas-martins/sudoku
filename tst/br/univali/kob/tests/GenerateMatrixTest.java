package br.univali.kob.tests;

import br.univali.kob.model.AppConfig;
import br.univali.kob.model.Matrix;
import br.univali.kob.model.MatrixPosition;


public class GenerateMatrixTest {
    public void runMatrixTest () {
        Matrix matrix = new Matrix(MatrixPosition.ONE);
        matrix.toString();
    }



    public static void main (String[] args) {
        GenerateMatrixTest generateMatrixTest = new GenerateMatrixTest();
        //generateMatrixTest.runMatrixTest();
        for (int i = 0; i < 9; i++) {
            System.out.println(AppConfig.BASE_MATRIX.get(i).toString());
        }
    }
}
