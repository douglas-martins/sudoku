package br.univali.kob.model;

import java.util.ArrayList;

public class Matrix {
    private ArrayList<ArrayList<MatrixCell>> elements;
    private MatrixPosition matrixPosition;
    private int emptyCells;

    public Matrix (MatrixPosition matrixPosition) {
        this.matrixPosition = matrixPosition;
        elements = new ArrayList<>();
        emptyCells = 0;
        resetMatrix();
    }

    public Matrix (MatrixPosition matrixPosition, ArrayList<ArrayList<MatrixCell>> elements) {
        this(matrixPosition);
        this.elements = elements;
    }

    public void setElements(ArrayList<ArrayList<MatrixCell>> elements) {
        this.elements = elements;
    }

    public ArrayList<ArrayList<MatrixCell>> getElements() {
        return elements;
    }

    public MatrixPosition getMatrixPosition() {
        return matrixPosition;
    }

    public int getEmptyCells() { return emptyCells; }

    public void setEmptyCells(int emptyCells) { this.emptyCells = emptyCells; }

    public void resetMatrix () {
        for (int i = 0; i < 3; i++) {
            ArrayList<MatrixCell> holder = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                MatrixCell cellHolder = new MatrixCell(i, i, j, false);
                holder.add(cellHolder);
            }
            elements.add(holder);
        }
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(this.getClass().hashCode()))
                .append(" { ")
                .append("\n    matrixPosition: " + matrixPosition + ", ")
                .append("\n    // Matrix")
                .append("\n" + matrixToString())
                .append("\n}");
        return objTxt.toString();
    }

    public String matrixToString () {
        StringBuilder objTxt = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            objTxt.append("[");
            for (int j = 0; j < 3; j++) {
                objTxt.append(elements.get(i).get(j).getCell())
                        .append(j != 2 ? " | " : "");
            }
            objTxt.append("]");
            if (i < 2) objTxt.append("\n");
        }
        return objTxt.toString();
    }
}
