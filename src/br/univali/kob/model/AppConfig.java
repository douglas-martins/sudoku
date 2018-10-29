package br.univali.kob.model;

import java.util.ArrayList;

public class AppConfig {
    public static final String APP_NAME;
    public static final String APP_VERSION;
    public static final ArrayList<Matrix> BASE_MATRIX;

    private static final ArrayList<Object> SETTINGS = new ArrayList<>();

    static {
        loadSettings();
        APP_NAME = (String)SETTINGS.get(0);
        APP_VERSION = (String)SETTINGS.get(1);
        BASE_MATRIX = (ArrayList<Matrix>)SETTINGS.get(2);
    }

    private static void loadSettings() {
        SETTINGS.add("Sudoku");
        SETTINGS.add("1.0");
        SETTINGS.add(generateBaseMatrix());
    }

    private static ArrayList<Matrix> generateBaseMatrix () {
        ArrayList<Matrix> matrix = new ArrayList<>();
        int[] firstMatrixValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] secondMatrixValues = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int[] thirdMatrixValues = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int[] fourthMatrixValues = {2, 3, 4, 5, 6, 7, 8, 9, 1};
        int[] fifthMatrixValues = {5, 6, 7, 8, 9, 1, 2, 3, 1};
        int[] sixthMatrixValues = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        int[] seventhMatrixValues = {3, 4, 5, 6, 7, 8, 9, 1, 2};
        int[] eighthMatrixValues = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        int[] ninthMatrixValues = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        matrix.add(0, smallBaseMatrix(MatrixPosition.ZERO, firstMatrixValues));
        matrix.add(1, smallBaseMatrix(MatrixPosition.ONE, secondMatrixValues));
        matrix.add(2, smallBaseMatrix(MatrixPosition.TWO, thirdMatrixValues));
        matrix.add(3, smallBaseMatrix(MatrixPosition.THREE, fourthMatrixValues));
        matrix.add(4, smallBaseMatrix(MatrixPosition.FOUR, fifthMatrixValues));
        matrix.add(5, smallBaseMatrix(MatrixPosition.FIVE, sixthMatrixValues));
        matrix.add(6, smallBaseMatrix(MatrixPosition.SIX, seventhMatrixValues));
        matrix.add(7, smallBaseMatrix(MatrixPosition.SEVEN, eighthMatrixValues));
        matrix.add(8, smallBaseMatrix(MatrixPosition.EIGHT, ninthMatrixValues));
        return matrix;
    }

    private static Matrix smallBaseMatrix (MatrixPosition position, int[] values) {
        ArrayList<ArrayList<MatrixCell>> matrix = new ArrayList<>();
        int jump = 0;
        for (int i = 0; i < 3; i++) {
            ArrayList<MatrixCell> holder = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                MatrixCell cell = new MatrixCell(values[j + jump], false, i, j);
                holder.add(cell);
            }
            matrix.add(i, holder);
            jump += 3;
        }
        return new Matrix(position, matrix);
    }
}
