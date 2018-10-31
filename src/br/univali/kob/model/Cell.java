package br.univali.kob.model;

import java.util.Objects;

public class Cell {
    private int cell;
    private final boolean isLocked;
    private int x;
    private int y;

    public Cell (int cell, int x, int y,  boolean isLocked) {
        this.cell = cell;
        this.x = x;
        this.y = y;
        this.isLocked = isLocked;
    }

    public int getCell() { return cell; }

    public void setCell(int cell) { this.cell = cell; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getIsLocked() { return isLocked; }

    @Override
    public boolean equals(Object obj) {
        if (this.equals(obj)) return true;
        if (!(obj instanceof Cell)) return false;
        Cell cell1 = (Cell) obj;
        return cell == cell1.cell &&
                isLocked == cell1.isLocked &&
                x == cell1.x &&
                y == cell1.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cell, isLocked, x, y);
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(hashCode()))
                .append("{")
                .append("\n    cell = " + cell)
                .append(",\n    isLocked = " + isLocked)
                .append(",\n    x = " + x)
                .append(",\n    y = " + y)
                .append("\n}");
        return objTxt.toString();
    }
}
