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

    public String tableToString () {
        StringBuilder objTxt = new StringBuilder();
        int counter = 0;
        while (counter < 9) {
            for (int i = 0; i < 3; i++) {
                objTxt.append("| ").append(tableRowToString(i, counter)).append("\n");
                swapGameTableRows(i, counter);
            }

            counter += 3;
        }
        return objTxt.toString();
    }

    private String tableRowToString (int k, int mod) {
        StringBuilder objTxt = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                objTxt.append(table.get(i + mod).getElements().get(k).get(j).getCell()).append(" | ");
            }
        }
        return objTxt.toString();
    }

    private void shuffleGameTableRows() {

    }

    private void shuffleGameTaleGroups() {

    }

    private void swapGameTableRows(int k, int mod) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ArrayList<MatrixCell> holder = table.get(i + mod).getElements().get(k);
                System.out.println(holder);
            }
        }
    }

    private void swapGameTableGroups() {

    }
}
