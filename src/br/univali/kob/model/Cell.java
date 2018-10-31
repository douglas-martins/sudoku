package br.univali.kob.model;

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
}
