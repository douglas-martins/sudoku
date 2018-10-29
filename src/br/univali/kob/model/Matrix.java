package br.univali.kob.model;

import java.util.ArrayList;

public class Matrix {
    private MatrixPosition matrixPosition;
    private ArrayList<ArrayList<MatrixCell>> matrix;

    public Matrix (MatrixPosition matrixPosition) {
        this.matrixPosition = matrixPosition;
        matrix = new ArrayList<ArrayList<MatrixCell>>();
        resetMatrix();
    }

    public Matrix (MatrixPosition matrixPosition, ArrayList<ArrayList<MatrixCell>> matrix) {
        this(matrixPosition);
        this.matrix = matrix;
    }

    public void resetMatrix () {
        for (int i = 0; i < 3; i++) {
            ArrayList<MatrixCell> holder = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                MatrixCell cellHolder = new MatrixCell(i, i, j);
                holder.add(cellHolder);
            }
            matrix.add(holder);
        }
        //System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(this.getClass().hashCode()))
                .append(" { ")
                .append("\n    matrixPosition: " + matrixPosition + ", ")
                .append("\n    // Matrix")
                .append("\n    " + matrixToString())
                .append("\n}");
        return objTxt.toString();
    }

    private String matrixToString () {
        StringBuilder objTxt = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            objTxt.append("[");
            for (int j = 0; j < 3; j++) {
                objTxt.append(matrix.get(i).get(j).getCell())
                        .append(j != 2 ? " | " : "");
            }
            objTxt.append("]");
            objTxt.append("\n    ");
        }
        return objTxt.toString();
    }
}
