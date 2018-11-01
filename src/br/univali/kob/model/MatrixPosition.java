package br.univali.kob.model;

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
    ZERO(0, 0),
    /**
     * Posição um.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    ONE(1, 0),
    /**
     * Posição dois.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    TWO(2, 0),
    /**
     * Posição três.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    THREE(3, 1),
    /**
     * Posição quatro.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    FOUR(4, 1),
    /**
     * Posição cinco.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    FIVE(5, 1),
    /**
     * Posição seis.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    SIX(6, 2),
    /**
     * Posição sete.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    SEVEN(7, 2),
    /**
     * Posição oito.
     * 1 valor da posição.
     * 2 grupo da posição.
     */
    EIGHT(8, 2);

    /**
     * Valor da posição.
     */
    private int value;
    /**
     * Valor do grupo da posição.
     */
    private int group;

    /**
     * Retorna o valor da posição.
     * @return int com o valor da posição.
     */
    public int getValue () { return value; }

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

    private MatrixPosition(int value, int group) {
        this.value = value;
        this.group = group;
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
