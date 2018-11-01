package br.univali.kob.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class SudokuGame {
    private SudokuGenerator sudokuGenerator;
    private LocalDate gameTime;
    private int validAttempts;
    private int invalidAttempts;

    public SudokuGame(GameDifficulty gameDifficulty) {
        this.sudokuGenerator = new SudokuGenerator(gameDifficulty);
        this.gameTime = LocalDate.parse(LocalDate.now().format(AppConfig.DATE_FORMAT), AppConfig.DATE_FORMAT);
    }

    public SudokuGenerator getSudoku() { return sudokuGenerator; }

    public LocalDate getGameTime() { return gameTime; }

    public void setGameTime(LocalDate gameTime) { this.gameTime = gameTime; }

    public int getValidAttempts() { return validAttempts; }

    public void setValidAttempts(int validAttempts) { this.validAttempts = validAttempts; }

    public int getInvalidAttpempts() { return invalidAttempts; }

    public void setInvalidAttpempts(int invalidAttempts) { this.invalidAttempts = invalidAttempts; }

    public boolean isGameOver() {
        return sudokuGenerator.getGameTableEmptyCellsNumber() <= 0;
    }

    public int gameElapsedTime() {
        return (int)Period.between(gameTime, LocalDate.now()).get(ChronoUnit.MINUTES);
    }

    public boolean isValidGameTablePosition(MatrixCell matrixCell) throws OutOfRangeException {
        return matrixCell.getCell().getX() <= 9 &&
                matrixCell.getCell().getY() <= 9;
    }

    public boolean isValidGameTableCellValue(MatrixCell matrixCell) throws OutOfRangeException {
        return matrixCell.getCell().getCellValue() <= 9 &&
                matrixCell.getCell().getCellValue() >= 0;
    }

    public boolean isValidGameTableCell (MatrixCell matrixCell) {
        return matrixCell.getCell().getIsLocked();
    }

    private LocalDate getTimeNow() {
        return LocalDate.parse(LocalDate.now().format(AppConfig.DATE_FORMAT), AppConfig.DATE_FORMAT);
    }
}
