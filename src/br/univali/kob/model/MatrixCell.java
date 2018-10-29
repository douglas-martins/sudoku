package br.univali.kob.model;

public class MatrixCell extends Cell {
    private int cell;

    public MatrixCell (int cell, int x, int y) {
        super(x, y);
        this.cell = cell;
    }

    public void setCell (int cell) {
        this.cell = cell;
    }

    public int getCell () {
        return cell;
    }

    @Override
    public String toString () {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(this.getClass().hashCode()))
                .append("{")
                .append("\n    cell: " + cell)
                .append("\n    x position: " + super.getX())
                .append("\n    y position: " + super.getY())
                .append("}");
        return objTxt.toString();
    }
}
