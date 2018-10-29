package br.univali.kob.model;

import java.util.ArrayList;

public class GameTable {
    private ArrayList<Matrix> table;
    private GameDifficulty gameDifficulty;

    public GameTable(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
        table = AppConfig.BASE_MATRIX;
    }

    private void shuffleGameTable() {

    }
}
