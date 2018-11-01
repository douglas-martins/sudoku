package br.univali.kob.model;

import java.util.ArrayList;
import java.util.Random;

/** zRepresenta a geração do Sudoku
 * matriz/grid/mesa da aplicação.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public class SudokuGenerator {
    /**
     * Matriz/grid/mesa da aplicação.
     */
    private ArrayList<Matrix> table;
    /**
     * Matriz correta dessa sessão do jogo.
     */
    private final ArrayList<Matrix> correctTable;
    /**
     * Dificuldade da aplicação que será gerada.
     */
    private GameDifficulty gameDifficulty;

    /**
     * Construtor padrão.
     * @param gameDifficulty valor da dificuldade do jogo nesta sessão.
     */
    public SudokuGenerator(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
        table = initGameTable(AppConfig.BASE_MATRIX);
        shuffleGameTable();
        correctTable = initGameTable(table);
        removeElementsByGameDifficulty();
    }

    /**
     * Retorna o valor da matriz/grid/mesa da aplicação.
     * @return ArrayList<Matrix> com o valor da matriz.
     */
    public ArrayList<Matrix> getTable() { return table; }

    /**
     * Retorna o valor da matriz/grid/mesa correta da aplicação.
     * @return ArrayList<Matrix> com o valor da matriz correta.
     */
    public ArrayList<Matrix> getCorrectTable() { return correctTable; }

    /**
     * Retorna o valor da dificuldade do jogo.
     * @return GameDifficulty com o valor da dificuldade do jogo.
     */
    public GameDifficulty getGameDifficulty() { return gameDifficulty; }

    private ArrayList<Matrix> initGameTable(ArrayList<Matrix> ref) {
        ArrayList<Matrix> holderTable = new ArrayList<>();
        for (int i = 0; i < ref.size(); i++) {
            Matrix matrix = new Matrix(ref.get(i));
            holderTable.add(i, matrix);
        }
        return holderTable;
    }

    /**
     * Embaralha a matriz/grid/mesa da sessão.
     */
    private void shuffleGameTable() {
        shuffleGameTableRows();
        shuffleGameTableGroups();
    }

    /**
     * Embaralha as linhas da sub-matriz da sessão.
     */
    private void shuffleGameTableRows() {
        int[] rows = shuffleGameTableType();
        swapGameTableRows(rows[0], rows[1]);
    }

    /**
     * Embaralha os grupos de sub-matriz da sessão.
     */
    private void shuffleGameTableGroups() {
        int[] groups = shuffleGameTableType();
        swapGameTableGroups(groups[0], groups[1]);
    }

    /**
     * Embaralha as sub-matriz (por linhas e grupos).
     * @return int[] com os valores embaralhados.
     */
    private int[] shuffleGameTableType() {
        int first = 0;
        int second = 0;
        do {
            first = randomNumberMatrixBounds();
            second = randomNumberMatrixBounds();
        } while (first == second || first > second);
        return new int[] { first, second };
    }

    /**
     * Troca linhas da matriz/grid/mesa (ou sub-matriz).
     * @param fRow posição da primeira linha que será trocada.
     * @param sRow posição da segunda linha que será trocada.
     */
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

    /**
     * Troca grupos da matriz/grid/mesa (trocando as sub-matriz).
     * @param fGroup posição do primeiro grupo que será trocada.
     * @param sGroup posição do segundo grupo que será trocada.
     */
    private void swapGameTableGroups(int fGroup, int sGroup) { // primeiro n pode ser maior que o segundo
        int counter = 0;
        for (Matrix matrix : table) {
            if (matrix.getMatrixPosition().getGroup() == fGroup) {
                ArrayList<ArrayList<MatrixCell>> holder = matrix.getElements();
                matrix.setElements(table.get(counter + (sGroup * 3)).getElements());
                table.get(counter + (sGroup * 3)).setElements(holder);
                counter++;
            }
        }
    }

    /**
     * Remove os elementos na matriz (ou sub-matriz), a partir da dificuldade do jogo.
     */
    private void removeElementsByGameDifficulty() {
        int emptyTotal = 0;
        do {
            makeGameTableTips();
            emptyTotal = getGameTableEmptyCellsNumber();
        } while (emptyTotal < (AppConfig.SUDOKU_CELLS_NUMBER - gameDifficulty.getTotalTips()));
    }

    /**
     * Adiciona as posições sem dicas (0) na matriz/grid/mesa (deixando as dicas isLocked = false).
     */
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
                if (matrix.getEmptyCells() >= gameDifficulty.getMinGridTips()) counter = 0;
            }
        }
    }

    /**
     * Remove uma célula (coloca em 0) da matriz/grid/mesa (célula contida na sub-matriz).
     * @param holder ArrayList<int[]> das posições disponíveis na sub-matriz
     *              (que não estão em 0 no valor da célula).
     * @param matrix Matrix que será alterada a célula.
     * @param counter int com o valor da quantidade real de células disponíveis
     *                usada para gerar uma posição aleátoria.
     * @return ArrayList<int[]> com os valores atualizado das posições diponíveis
     *         após remover um elemento.
     */
    private ArrayList<int[]> removeOneCellFromGrid(ArrayList<int[]> holder, Matrix matrix, int counter) {
        int elementPosition = new Random().nextInt(counter);
        if (matrix.getElements().get(holder.get(elementPosition)[0])
                .get(holder.get(elementPosition)[1]).getCell().getCellValue() == 0) return new ArrayList<>(holder);

        matrix.getElements().get(holder.get(elementPosition)[0])
                .get(holder.get(elementPosition)[1])
                .setCell(new Cell(0,
                        holder.get(elementPosition)[0],
                        holder.get(elementPosition)[1],
                        false));
        matrix.setEmptyCells(matrix.getEmptyCells() + 1);
        holder.remove(elementPosition);
        return new ArrayList<>(holder);
    }

    /**
     * Gera um número aleátorio (dentro do limites da sub-matriz).
     * @return int com o valor da posição da sub-matriz.
     */
    private int randomNumberMatrixBounds() {
        int [] numbers = { 0, 1, 2 };
        return numbers[new Random().nextInt(3)];
    }

    /**
     * Imprimi a matriz/grid/mesa.
     * @param holderTable matriz/grid/mesa que será imprimida.
     * @return String com a matriz/grid/mesa.
     */
    public String tableToString (ArrayList<Matrix> holderTable) {
        StringBuilder objTxt = new StringBuilder();
        int counter = 0;
        while (counter < 9) {
            for (int i = 0; i < 3; i++) {
                objTxt.append("| ").append(tableRowToString(holderTable, i, counter)).append("\n");
            }
            counter += 3;
        }
        return objTxt.toString();
    }

    /**
     * Imprimi uma linha da matriz.
     * @param holderTable matriz/grid/mesa da onde iremos imprimir a linha,
     * @param k posição na sub-matriz da célula que será imprimida.
     * @param mod modificador para pular de uma linha para outra na sub-matriz.
     * @return String com a linha da matriz.
     */
    private String tableRowToString (ArrayList<Matrix> holderTable, int k, int mod) {
        StringBuilder objTxt = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                objTxt.append(holderTable.get(i + mod).getElements().get(k).get(j).getCell().getCellValue()).append(" | ");
            }
        }
        return objTxt.toString();
    }

    /**
     * Retorna o valor total de células vazias (0) na matriz/grid/mesa.
     * @return int com o valor toal de células vazias (0).
     */
    public int getGameTableEmptyCellsNumber() {
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
                .append("\n    table ")
                .append(" @ " + Integer.toHexString(table.hashCode()))
                .append("\n    " + tableToString(table))                .append("\n    correctTable ")
                .append(" @ " + Integer.toHexString(correctTable.hashCode()))
                .append("\n    " + tableToString(correctTable))
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
        SudokuGenerator sudokuGenerator = (SudokuGenerator)obj;
        return (table == sudokuGenerator.table || table.equals(sudokuGenerator.table)) &&
                (correctTable == sudokuGenerator.correctTable
                        || correctTable.equals(sudokuGenerator.correctTable)) &&
                (gameDifficulty == sudokuGenerator.gameDifficulty
                        || gameDifficulty.equals(sudokuGenerator.gameDifficulty));
    }
}
