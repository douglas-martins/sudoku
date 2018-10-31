package br.univali.kob.model;

public class MatrixCell extends Cell {
    public MatrixCell (int cell, int x, int y, boolean isLocked) {
        super(cell, x, y, isLocked);
    }

    @Override
    public String toString () {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(this.getClass().hashCode()))
                .append("{")
                .append("\n    // Cell")
                .append("\n    " + super.toString())
//                .append("\n    Cell { ")
//                .append("\n        cell: " + super.getCell())
//                .append("\n        x: " + super.getX())
//                .append("\n        y: " + super.getY())
                .append("\n}");
        return objTxt.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        MatrixCell matrixCell =  (MatrixCell)obj;
        return getCell() == matrixCell.getCell() &&
                getX() == matrixCell.getX() &&
                getY() == matrixCell.getY() &&
                getIsLocked() == matrixCell.getIsLocked();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
