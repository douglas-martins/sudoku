package br.univali.kob.model;

import java.util.ArrayList;

/** Representa uma matriz (sub-matriz na aplicação).
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public class Matrix {
    /**
     * Uma matriz (sub-matriz na aplicação).
     */
    private ArrayList<ArrayList<MatrixCell>> elements;
    /**
     * Posição da sub-matriz na matriz/grid da aplicação
     * (0, 1 e 2 { superior } | 3, 4 e 5 { meio } | 5, 7 e 8 { inferior }).
     */
    private MatrixPosition matrixPosition;
    /**
     * Quantidade de células vazia na matriz (sub-matriz na aplicação).
     */
    private int emptyCells;

    /**
     * Construtor da classe Matrix.
     * Inicializa a matriz, zera o numero de zeros nela e chama a operação resetMatrix().
     * @param matrixPosition valor da posição da sub-matriz na matriz/grid da aplicação.
     */
    public Matrix (MatrixPosition matrixPosition) {
        this.matrixPosition = matrixPosition;
        elements = new ArrayList<>();
        emptyCells = 0;
        resetMatrix();
    }

    /**
     * Construtor da classe Matrix.
     * Inicializa a matriz, zera o numero de zeros nela, chama a operação resetMatrix() e
     * atribui o valor de elements para a matriz (sub-matriz na aplicação).
     * @param matrixPosition valor da posição da sub-matriz na matriz/grid da aplicação.
     * @param elements valor que será atribuido a matrix (sub-matriz no sistema).
     */
    public Matrix (MatrixPosition matrixPosition, ArrayList<ArrayList<MatrixCell>> elements) {
        this(matrixPosition);
        this.elements = elements;
    }

    /**
     * Construtor para copia de objeto "deep clone".
     * @param matrix objeto Matrix o qual irá ser copiado
     */
    public Matrix (Matrix matrix) {
        resetMatrix();
        for (int i = 0; i < matrix.elements.size(); i++) {
            for (int j = 0; j < matrix.elements.get(i).size(); j++) {
                this.elements.get(i).get(j)
                        .setCell(new Cell(matrix.getElements().get(i).get(j).getCell()));
            }
        }
        this.matrixPosition = matrix.matrixPosition;
    }

    /**
     * Modifica o valor da matriz (sub-matriz na aplicação) de maneira geral.
     * @param elements novo valor para a matriz (sub-matriz na aplicação).
     */
    public void setElements(ArrayList<ArrayList<MatrixCell>> elements) { this.elements = elements; }

    /**
     * Retorna o valor da matriz (sub-matriz na aplicação).
     * @return ArrayList<ArrayList<MatrixCell>> com o valor da matriz (sub-matriz na aplicação).
     */
    public ArrayList<ArrayList<MatrixCell>> getElements() { return elements; }

    /**
     * Retorna o valor da posição da matriz (sub-matriz na aplicação).
     * @return MatrixPosition com o valor da posição da sub-matriz na matriz/grid da aplicação.
     */
    public MatrixPosition getMatrixPosition() {
        return matrixPosition;
    }

    /**
     * Retorna o valor da quantidade células vazias (0) na matriz (sub-matriz na aplicação).
     * @return int com o valor da quantidade de células vazias (0).
     */
    public int getEmptyCells() { return emptyCells; }

    /**
     * Modifica o valor de células vazias (0).
     * @param emptyCells valor da quantidade de células vazias.
     */
    public void setEmptyCells(int emptyCells) { this.emptyCells = emptyCells; }

    /**
     * Reseta a matriz (valor 0 para todas as células).
     */
    public void resetMatrix () {
        //emptyCells = 0;
        elements = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<MatrixCell> holder = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                MatrixCell cellHolder = new MatrixCell(0, i, j, false);
                holder.add(cellHolder);
                //emptyCells++;
            }
            elements.add(holder);
        }
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(this.getClass().hashCode()))
                .append(" { ")
                .append("\n    matrixPosition: " + matrixPosition + ", ")
                .append("\n    // Matrix")
                .append("\n" + matrixToString())
                .append("\n}");
        return objTxt.toString();
    }

    @Override
    public int hashCode () {
        return elements.hashCode() ^
                matrixPosition.hashCode() ^
                emptyCells;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.equals(obj)) return false;
        Matrix matrix = (Matrix)obj;
        return (elements == matrix.elements || elements.equals(matrix.elements)) &&
                (matrixPosition == matrix.matrixPosition || matrixPosition.equals(matrix.matrixPosition)) &&
                emptyCells == matrix.emptyCells;
    }

    /**
     * Imprime a matriz (sub-matriz no sistema).
     * @return String que contém a matriz.
     */
    public String matrixToString () {
        StringBuilder objTxt = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            objTxt.append("[");
            for (int j = 0; j < 3; j++) {
                objTxt.append(elements.get(i).get(j).getCell().getCellValue())
                        .append(j != 2 ? " | " : "");
            }
            objTxt.append("]");
            if (i < 2) objTxt.append("\n");
        }
        return objTxt.toString();
    }
}
