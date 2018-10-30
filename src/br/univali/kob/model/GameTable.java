package br.univali.kob.model;

import java.util.ArrayList;
import java.util.Random;

public class GameTable {
    private ArrayList<Matrix> table;
    private GameDifficulty gameDifficulty;

    public GameTable(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
        table = AppConfig.BASE_MATRIX;
        shuffleGameTable();
    }

    public void shuffleGameTable() {
        shuffleGameTableRows();
        shuffleGameTaleGroups();
    }

    public String tableToString () {
        StringBuilder objTxt = new StringBuilder();
        int counter = 0;
        while (counter < 9) {
            for (int i = 0; i < 3; i++) {
                objTxt.append("| ").append(tableRowToString(i, counter)).append("\n");
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
        int fRow = 0;
        int sRow = 0;
        do {
            fRow = randomNumberMatrixBounds();
            sRow = randomNumberMatrixBounds();
        } while (fRow == sRow || fRow > sRow);
        swapGameTableRows(fRow, sRow);
    }

    private void shuffleGameTaleGroups() {
        int fGroup = 0;
        int sGroup = 0;
        do {
            fGroup = randomNumberMatrixBounds();
            sGroup = randomNumberMatrixBounds();
        } while (fGroup == sGroup || fGroup > sGroup);
        swapGameTableGroups(fGroup, sGroup);
    }

    private void swapGameTableRows(int fRow, int sRow) { // primeiro n pode ser maior que o segundo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                MatrixCell holder = table.get(i).getElements().get(fRow).get(j);
                table.get(i).getElements().get(fRow).set(j,
                        table.get(i).getElements().get(sRow).get(j));
                table.get(i).getElements().get(sRow).set(j, holder);
            }
        }
    }

    private void swapGameTableGroups(int fGroup, int sGroup) { // primeiro n pode ser maior que o segundo
        int counter = 0;
        for (Matrix matrix : table) {
            if (matrix.getMatrixPosition().getGroup() == fGroup) {
                ArrayList<ArrayList<MatrixCell>> holder2 = matrix.getElements();
                matrix.setElements(table.get(counter + (sGroup * 3)).getElements());
                table.get(counter + (sGroup * 3)).setElements(holder2);
                counter++;
            }
        }
    }

    private int randomNumberMatrixBounds() {
        int [] numbers = { 0, 1, 2 };
        return numbers[new Random().nextInt(3)];
    }
}
