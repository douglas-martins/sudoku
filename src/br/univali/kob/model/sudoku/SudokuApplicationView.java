package br.univali.kob.model.sudoku;

import br.univali.kob.model.*;
import br.univali.kob.model.helpers.Console;
import br.univali.kob.model.helpers.OutOfRangeException;
import br.univali.kob.model.helpers.Validator;
import br.univali.kob.model.matrix.Cell;
import br.univali.kob.model.matrix.Matrix;
import br.univali.kob.model.matrix.MatrixCell;
import br.univali.kob.model.matrix.MatrixPosition;

/** Representa a parte que cuida dos I/O
 * para o game.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public class SudokuApplicationView {
    /**
     * Objeto que contém o jogo.
     */
    private SudokuGame sudokuGame;

    /**
     * Construtor padrão.
     */
    public SudokuApplicationView() {
        this.sudokuGame = new SudokuGame(askForDifficulty());
    }

    /**
     * Retorna o objeto que contém o jogo.
     * @return SudokuGame com o valor do jogo.
     */
    public SudokuGame getSudokuGame() { return sudokuGame; }

    /**
     * Pede para o jogar entrar com as posições na matriz (x, y)
     * para adicionar uma célula.
     */
    public void askForPlay() {
        int[] positions = askForInputPosition();
        MatrixCell matrixCell = askForCellValue(positions);
        placeMatrixCell(matrixCell);
    }

    /**
     * Coloca uma célula na matriz (não permitindo sobescrever as dicas).
     * @param matrixCell MatrixCell que contém o valor da célula que será inserida
     *                   e a posição.
     */
    private void placeMatrixCell(MatrixCell matrixCell) { // aqui
        int jumpX = MatrixPosition.adjustSubMatrixPosition(matrixCell.getCell().getX());
        int jumpY = MatrixPosition.adjustSubMatrixPosition(matrixCell.getCell().getY());

        Validator.notNull(getSubMatrixPosition(new int[] {
                matrixCell.getCell().getX(), matrixCell.getCell().getY() }), "SubMatrix");
        MatrixPosition matrixPosition = getSubMatrixPosition(new int[] {
                matrixCell.getCell().getX(), matrixCell.getCell().getY() });

        try {
            if (!sudokuGame.isValidGameTableCell(matrixCell)) {
                throw new IllegalArgumentException("Local inválido/bloqueado! Por favor, entre com uma nova posição\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            placeMatrixCell(askForCellValue(askForInputPosition()));
        }

        sudokuGame.getSudoku().getTable()
                .get(matrixPosition.getValue())
                .getElements()
                .get(jumpX)
                .get(jumpY)
                .setCell(matrixCell.getCell());
    }

    /**
     *
     * @return
     */
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

        try {
            sudokuGame.getSudoku().getTable().get(0).getElements().get(x).get(y);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid position! " + e);
            System.out.println();
            askForInputPosition();
        }
        return new int[] { x, y };
    }

    /**
     * Pede para um usuário informar um valor para célula da matriz.
     * @param positions int[] com os valores da posição na matriz.
     * @return MatrixCell com o valor célula e sua posição na matriz.
     */
    private MatrixCell askForCellValue(int[] positions) {
        int value = Console.readlnInt("Digite um valor para célula."
                + "\n(0 apaga a célula, 1..9 numeros validos)"
                + "\nEx: 1"
                + "\n");
        try {
            if (!sudokuGame.isValidGameTableCellValue(new MatrixCell(value, positions[0], positions[1]))) {
                throw new OutOfRangeException(value, "Valor invalido para uma celula!", 1, 9);
            }
        } catch (OutOfRangeException e) {
            System.out.println(e);
            askForCellValue(positions);
        }

        Cell cell = new Cell(value,
                MatrixPosition.adjustSubMatrixPosition(positions[0]),
                MatrixPosition.adjustSubMatrixPosition(positions[1]),
                false);
        return new MatrixCell(cell.getCellValue(), cell.getX(), cell.getY(), cell.getIsLocked());
    }

    /**
     * Pede para o usuário informar a dificuldade desejada do game.
     * @return GameDifficulty com o valor da dificuldade do jogo.
     */
    public GameDifficulty askForDifficulty() {
        int difficulty = Console.readlnInt("Digite a dificuldade desejada. "
                + "\n1) Easy."
                + "\n2) Médio."
                + "\n3) Difícil."
                + "\n");
        try {
            return GameDifficulty.values()[difficulty - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid choice! " + e + "\n");
            System.out.println();
            askForDifficulty();
        }
        return null;
    }

    /**
     * Retorna a posição da sub-matriz na table do game.
     * @param positions int[] com a posição (x, y).
     * @return MatrixPosition com o valor da posição da sub-matriz na table do game.
     */
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
