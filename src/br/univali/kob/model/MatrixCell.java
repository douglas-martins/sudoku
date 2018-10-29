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
                .append("\n    cell: " + super.getCell())
                .append("\n    x position: " + super.getX())
                .append("\n    y position: " + super.getY())
                .append("}\n");
        return objTxt.toString();
    }
}
