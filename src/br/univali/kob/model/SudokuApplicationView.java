package br.univali.kob.model;

import br.univali.kob.model.helpers.Console;

public class SudokuApplicationView {
    private SudokuGenerator sudokuGenerator;

    public SudokuApplicationView() {
        this.sudokuGenerator = new SudokuGenerator(askForDifficulty());
    }

    public SudokuGenerator getSudokuGenerator() { return sudokuGenerator; }

    public void placeMatrixCell() { // aqui
        int[] positions = askForInputPosition();
        int jumpX = MatrixPosition.adjustSubMatrixPosition(positions[0]);
        int jumpY = MatrixPosition.adjustSubMatrixPosition(positions[1]);


        MatrixCell matrixCell = askForCellValue(positions);
        sudokuGenerator.getGameTable().getTable()
                .get(matrixCell.getCell().getY())
                .getElements()
                .get(jumpX)
                .get(jumpY)
                .setCell(matrixCell.getCell());
    }

    public int[] askForInputPosition() {
        System.out.println(sudokuGenerator.getGameTable()
                .tableToString(sudokuGenerator.getGameTable().getTable()));
        int x = Console.readlnInt("Digite um valor de x correspondente\n"
                        + "a posição do elemento que deseja alterar."
                        + "\nEx.: 1 ");
        if (x > 0) x--;

        int y = Console.readlnInt("Digite um valor de y correspondente\n"
                + "a posição do elemento que deseja alterar."
                + "\nEx.: 1 ");
        if (y > 0) y--;

        return new int[] { x, y };
    }

    public MatrixCell askForCellValue(int[] positions) {
        System.out.println("GAME TABLE: ");
        int value = Console.readlnInt("Digite um valor para célula."
                + "\n(0 apaga a célula, 1..9 numeros validos)"
                + "\nEx: 1");
        Cell cell = new Cell(value, positions[0], positions[1], false);
        return new MatrixCell(cell.getCellValue(), cell.getX(), cell.getY(), cell.getIsLocked());
    }

    public GameDifficulty askForDifficulty() {
        int difficulty = Console.readlnInt("Digite a dificuldade desejada. "
                + "\n1) Easy."
                + "\n2) Médio."
                + "\n3) Difícil.");
        return GameDifficulty.values()[difficulty - 1];
    }
}
