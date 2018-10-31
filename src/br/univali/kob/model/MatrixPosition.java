package br.univali.kob.model;

public enum MatrixPosition {
    ZERO(0, 0), ONE(1, 0), TWO(2, 0),
    THREE(3, 1), FOUR(4, 1), FIVE(5, 1),
    SIX(6, 2), SEVEN(7, 2), EIGHT(8, 2);

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

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(hashCode()))
                .append(" { ")
                .append("\n    value = " + value)
                .append("\n    group = " + group)
                .append("\n}");
        return objTxt.toString();
    }
}
