package br.univali.kob.model;

import java.util.ArrayList;

/** Representa posição da sub-matriz na matriz/grid/mesa.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public enum MatrixPosition {
    /**
     * Posição zero.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    ZERO(0, 0, new int[][]{
            { 0, 0 }, { 0, 1 }, { 0, 2 },  { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 }
    }),
    /**
     * Posição um.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    ONE(1, 0, new int[][]{
            { 0, 3 }, { 0, 4 }, { 0, 5 },  { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 4 }, { 2, 5 }
    }),
    /**
     * Posição dois.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    TWO(2, 0, new int[][]{
            { 0, 6 }, { 0, 7 }, { 0, 8 },  { 1, 6 }, { 1, 7 }, { 1, 8 }, { 2, 6 }, { 2, 7 }, { 2, 8 }
    }),
    /**
     * Posição três.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    THREE(3, 1, new int[][]{
            { 3, 0 }, { 3, 1 }, { 3, 2 },  { 4, 0 }, { 4, 1 }, { 4, 2 }, { 5, 0 }, { 5, 1 }, { 5, 2 }
    }),
    /**
     * Posição quatro.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    FOUR(4, 1, new int[][]{
            { 3, 3 }, { 3, 4 }, { 3, 5 },  { 4, 3 }, { 4, 4 }, { 4, 5 }, { 5, 3 }, { 5, 4 }, { 5, 5 }
    }),
    /**
     * Posição cinco.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    FIVE(5, 1, new int[][]{
            { 3, 6 }, { 3, 7 }, { 3, 8 },  { 4, 6 }, { 4, 7 }, { 4, 8 }, { 5, 6 }, { 5, 7 }, { 5, 8 }
    }),
    /**
     * Posição seis.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    SIX(6, 2, new int[][]{
            { 6, 0 }, { 6, 1 }, { 6, 2 },  { 7, 0 }, { 7, 1 }, { 7, 2 }, { 8, 0 }, { 8, 1 }, { 8, 2 }
    }),
    /**
     * Posição sete.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    SEVEN(7, 2, new int[][]{
            { 6, 3 }, { 6, 4 }, { 6, 5 },  { 7, 3 }, { 7, 4 }, { 7, 5 }, { 8, 3 }, { 8, 4 }, { 8, 5 }
    }),
    /**
     * Posição oito.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    EIGHT(8, 2, new int[][]{
            { 6, 6 }, { 6, 7 }, { 6, 8 },  { 7, 6 }, { 7, 7 }, { 7, 8 }, { 8, 6 }, { 8, 7 }, { 8, 8 }
    });

    /**
     * Valor da posição.
     */
    private int value;

    /**
     * Valor do grupo da posição.
     */
    private int group;

    private int[][] xYGroupPosition;

    /**
     * Retorna o valor da posição.
     * @return int com o valor da posição.
     */
    public int getValue () { return value; }

    public int[][] getxYGroupPosition() { return xYGroupPosition; }

    /**
     * Retorna o valor do grupo.
     * @return int com o valor do grupo.
     */
    public int getGroup() { return group; }

    public static int adjustSubMatrixPosition(int position) {
        int posReturn = position;
        if (position <= 5 && position > 2) {
            posReturn -= 3;
        } else if (position > 5) {
            posReturn -= 2 * 3;
        }
        return posReturn;
    }

    private MatrixPosition(int value, int group, int[][] xYGroupPosition) {
        this.value = value;
        this.group = group;
        this.xYGroupPosition = xYGroupPosition;
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(hashCode()))
                .append(" { ")
                .append("\n    value = " + value)
                .append("\n    group = " + group)
                .append("\n}");
        return objTxt.toString();
    }
}
