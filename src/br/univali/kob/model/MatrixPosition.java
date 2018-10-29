package br.univali.kob.model;

public enum MatrixPosition {
    ZERO(0, 1), ONE(1, 1), TWO(2, 1), THREE(3, 2), FOUR(4, 2),
    FIVE(5, 2), SIX(6, 3), SEVEN(7, 3), EIGHT(8, 3);

    private int value;
    private int group;

    public int getValue () {
        return value;
    }
    public int getGroup() { return group; }

    private MatrixPosition(int value, int group) {
        this.value = value;
        this.group = group;
    }
}
