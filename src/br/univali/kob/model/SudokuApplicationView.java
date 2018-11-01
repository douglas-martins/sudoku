package br.univali.kob.model;

import br.univali.kob.model.helpers.Console;

import java.util.ArrayList;

public class SudokuApplicationView {
    private SudokuGame sudokuGame;

    public SudokuApplicationView() {
        this.sudokuGame = new SudokuGame(askForDifficulty());
    }

    public SudokuGame getSudokuGame() { return sudokuGame; }

    public void askForPlay() {
        int[] positions = askForInputPosition();
        MatrixCell matrixCell = askForCellValue(positions);
        placeMatrixCell(matrixCell);
    }

    private void placeMatrixCell(MatrixCell matrixCell) { // aqui
        int jumpX = MatrixPosition.adjustSubMatrixPosition(matrixCell.getCell().getX());
        int jumpY = MatrixPosition.adjustSubMatrixPosition(matrixCell.getCell().getY());

        MatrixPosition matrixPosition = getSubMatrixPosition(new int[] {
                matrixCell.getCell().getX(), matrixCell.getCell().getY() });

        if (sudokuGame.getSudoku().getTable()
                .get(matrixPosition.getValue()).getElements()
                .get(jumpX).get(jumpY).getCell().getIsLocked()) { // criar exceção
            System.out.println("LOCAL INVALIDO/BLOQUEADO.\n");
            return;
        }

        sudokuGame.getSudoku().getTable()
                .get(matrixPosition.getValue())
                .getElements()
                .get(jumpX)
                .get(jumpY)
                .setCell(matrixCell.getCell());
    }

    private int[] askForInputPosition() {
        System.out.println(sudokuGame.getSudoku()
                .tableToString(sudokuGame.getSudoku().getTable()));
        int x = Console.readlnInt("Digite um valor de x correspondente\n"
                        + "a posição do elemento que deseja alterar."
                        + "\nEx.: 1 "
                        + "\n");
        if (x > 0) x--;

        int y = Console.readlnInt("Digite um valor de y correspondente\n"
                + "a posição do elemento que deseja alterar."
                + "\nEx.: 1 "
                + "\n");
        if (y > 0) y--;

        return new int[] { x, y };
    }

    private MatrixCell askForCellValue(int[] positions) {
        System.out.println("GAME TABLE: ");
        int value = Console.readlnInt("Digite um valor para célula."
                + "\n(0 apaga a célula, 1..9 numeros validos)"
                + "\nEx: 1"
                + "\n");
        Cell cell = new Cell(value,
                MatrixPosition.adjustSubMatrixPosition(positions[0]),
                MatrixPosition.adjustSubMatrixPosition(positions[1]),
                false);
        return new MatrixCell(cell.getCellValue(), cell.getX(), cell.getY(), cell.getIsLocked());
    }

    public GameDifficulty askForDifficulty() {
        int difficulty = Console.readlnInt("Digite a dificuldade desejada. "
                + "\n1) Easy."
                + "\n2) Médio."
                + "\n3) Difícil."
                + "\n");
        return GameDifficulty.values()[difficulty - 1];
    }

    private MatrixPosition getSubMatrixPosition(int[] positions) {
        for (Matrix matrix : sudokuGame.getSudoku().getTable()) {
            for (int i = 0; i < 9; i++) {
                if (matrix.getMatrixPosition().getxYGroupPosition()[i][0] == positions[0]
                        && matrix.getMatrixPosition().getxYGroupPosition()[i][1] == positions[1]) {
                    return matrix.getMatrixPosition();
                }
            }
        }
        return null;
    }
}
