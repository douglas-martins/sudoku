package br.univali.kob.model;

import java.util.ArrayList;
import java.util.Random;

public class GameTable {
    private ArrayList<Matrix> table;
    private final ArrayList<Matrix> correctTable;
    private GameDifficulty gameDifficulty;

    public GameTable(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
        table = new ArrayList<>(AppConfig.BASE_MATRIX);
        correctTable = new ArrayList<>(table);
        shuffleGameTable();
        removeElements();
    }

    public ArrayList<Matrix> getTable() { return table; }

    public ArrayList<Matrix> getCorrectTable() { return correctTable; }

    public GameDifficulty getGameDifficulty() { return gameDifficulty; }

    private void shuffleGameTable() {
        shuffleGameTableRows();
        shuffleGameTableGroups();
    }

    private void shuffleGameTableRows() {
        int[] rows = shuffleGameTableType();
        swapGameTableRows(rows[0], rows[1]);
    }

    private void shuffleGameTableGroups() {
        int[] groups = shuffleGameTableType();
        swapGameTableGroups(groups[0], groups[1]);
    }

    private int[] shuffleGameTableType() {
        int first = 0;
        int second = 0;
        do {
            first = randomNumberMatrixBounds();
            second = randomNumberMatrixBounds();
        } while (first == second || first > second);
        return new int[] { first, second };
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

    private void removeElements() {
        int emptyTotal = 0;
        do {
            makeGameTableTips();
            emptyTotal = getGameTableEmptyCellsNumber();
        } while (emptyTotal < (AppConfig.SUDOKU_CELLS_NUMBER - gameDifficulty.getTotalTips()));
    }

    private void makeGameTableTips() {
        ArrayList<int[]> elementsPos = new ArrayList<>();
        ArrayList<int[]> holder = new ArrayList<>(elementsPos);
        int counter = 9;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                elementsPos.add(new int[] { i, j });
            }
        }

        for (Matrix matrix : table) {
            if (getGameTableEmptyCellsNumber() == (AppConfig.SUDOKU_CELLS_NUMBER - gameDifficulty.getTotalTips())) break;
            counter = 9;
            holder = new ArrayList<>(elementsPos);
            while (counter > 0) {
                holder = removeOneCellFromGrid(holder, matrix, counter);
                counter--;
                if (matrix.getEmptyCells() >= gameDifficulty.getMinGridTips())counter = 0;
            }
        }
    }

    private ArrayList<int[]> removeOneCellFromGrid(ArrayList<int[]> holder, Matrix matrix, int counter) {
        int elementPosition = new Random().nextInt(counter);
        if (matrix.getElements().get(holder.get(elementPosition)[0])
                .get(holder.get(elementPosition)[1]).getCell() == 0) return new ArrayList<>(holder);

        matrix.getElements().get(holder.get(elementPosition)[0])
                .get(holder.get(elementPosition)[1]).setCell(0);
        matrix.setEmptyCells(matrix.getEmptyCells() + 1);
        holder.remove(elementPosition);
        return new ArrayList<>(holder);
    }

    private int randomNumberMatrixBounds() {
        int [] numbers = { 0, 1, 2 };
        return numbers[new Random().nextInt(3)];
    }

    public String tableToString (ArrayList<Matrix> table) {
        StringBuilder objTxt = new StringBuilder();
        int counter = 0;
        while (counter < 9) {
            for (int i = 0; i < 3; i++) {
                objTxt.append("| ").append(tableRowToString(table, i, counter)).append("\n");
            }
            counter += 3;
        }
        return objTxt.toString();
    }

    private String tableRowToString (ArrayList<Matrix> table, int k, int mod) {
        StringBuilder objTxt = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                objTxt.append(table.get(i + mod).getElements().get(k).get(j).getCell()).append(" | ");
            }
        }
        return objTxt.toString();
    }

    private int getGameTableEmptyCellsNumber() {
        int total = 0;
        for (Matrix matrix : table) {
            total += matrix.getEmptyCells();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(this.getClass().hashCode()))
                .append(" { ")
                .append("\n    table = " + tableToString(table))
                .append("\n    correctTable = " + tableToString(correctTable))
                .append("\n    gameDifficulty = " + gameDifficulty.toString())
                .append("\n}");
        return objTxt.toString();
    }

    @Override
    public int hashCode() {
        return table.hashCode() ^ correctTable.hashCode() ^ gameDifficulty.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.equals(obj)) return false;
        GameTable gameTable = (GameTable)obj;
        return (table == gameTable.table || table.equals(gameTable.table)) &&
                (correctTable == gameTable.correctTable || correctTable.equals(gameTable.correctTable)) &&
                (gameDifficulty == gameTable.gameDifficulty || gameDifficulty.equals(gameTable.gameDifficulty));
    }
}
