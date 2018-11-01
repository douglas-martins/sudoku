package br.univali.kob.model;

import br.univali.kob.model.helpers.Console;

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

        return new int[] { x, y };
    }

    /**
     * Pede para um usuário informar um valor para célula da matriz.
     * @param positions int[] com os valores da posição na matriz.
     * @return MatrixCell com o valor célula e sua posição na matriz.
     */
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
        return GameDifficulty.values()[difficulty - 1];
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
