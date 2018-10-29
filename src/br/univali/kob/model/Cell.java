package br.univali.kob.model;

public class Cell {
    private int cell;
    private final boolean isLocked;
    private int x;
    private int y;

    public Cell (int cell, boolean isLocked, int x, int y) {
        this.cell = cell;
        this.isLocked = isLocked;
        this.x = x;
        this.y = y;
    }

    public int getCell() { return cell; }

    public void setCell(int cell) { this.cell = cell; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
