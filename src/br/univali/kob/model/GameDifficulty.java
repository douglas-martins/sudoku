package br.univali.kob.model;

public enum GameDifficulty {
    EASY(36, 3), MEDIUM(32, 3), HARD(27, 2);

    private int totalTips;
    private int minGridTips;

    public int getTotalTips() {
        return totalTips;
    }
    public int getMinGridTips() {
        return minGridTips;
    }

    private GameDifficulty(int totalTips, int minGridTips) {
        this.totalTips = totalTips;
        this.minGridTips = minGridTips;
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(hashCode()))
                .append(" { ")
                .append("\n    totalTips = " + totalTips)
                .append("\n    minGridTips = " + minGridTips)
                .append("\n}");
        return objTxt.toString();
    }
}
