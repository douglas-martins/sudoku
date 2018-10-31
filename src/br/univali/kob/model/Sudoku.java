package br.univali.kob.model;

import java.time.LocalDate;

public class Sudoku {
    private GameTable gameTable;
    private LocalDate gameTime;
    private int validAttempts;
    private int invalidAttempts;

    public Sudoku(GameDifficulty gameDifficulty) {
        this.gameTable = new GameTable(gameDifficulty);
        this.gameTime = LocalDate.parse(LocalDate.now().format(AppConfig.DATE_FORMAT), AppConfig.DATE_FORMAT);
    }

    public GameTable getGameTable() { return gameTable; }

    public LocalDate getGameTime() { return gameTime; }

    public void setGameTime(LocalDate gameTime) { this.gameTime = gameTime; }

    public int getValidAttempts() { return validAttempts; }

    public void setValidAttempts(int validAttempts) { this.validAttempts = validAttempts; }

    public int getInvalidAttpempts() { return invalidAttempts; }

    public void setInvalidAttpempts(int invalidAttempts) { this.invalidAttempts = invalidAttempts; }

    public boolean isGameOver() {
        return gameTable.getGameTableEmptyCellsNumber() <= 0;
    }

    public boolean isValidGameTablePosition(MatrixCell matrixCell) {
        return matrixCell.getCell().getX() <= 9 &&
                matrixCell.getCell().getY() <= 9;
    }

    public boolean isValidGameTableCellValue(MatrixCell matrixCell) {
        return matrixCell.getCell().getCellValue() <= 9 &&
                matrixCell.getCell().getCellValue() >= 0;
    }
}
