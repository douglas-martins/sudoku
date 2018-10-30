package br.univali.kob.model;

public enum GameDifficulty {
    EASY(36, 3), MEDIUM(32, 3), HARD(27, 2);

    private int totalTips;
    private int gridTips;

    public int getTotalTips() {
        return totalTips;
    }
    public int getGridTips() {
        return gridTips;
    }

    private GameDifficulty(int totalTips, int gridTips) {
        this.totalTips = totalTips;
        this.gridTips = gridTips;
    }
}
