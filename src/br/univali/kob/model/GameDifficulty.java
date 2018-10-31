package br.univali.kob.model;

/** Representa a dificuldade da aplicação.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public enum GameDifficulty {
    /**
     * Dificuldade fácil.
     * 1 parâmetro: valor total de dicas.
     * 2 parâmetro: valor min de dicas em cada sub-matriz.
     */
    EASY(36, 3),
    /**
     * Dificuldade médio.
     * 1 parâmetro: valor total de dicas.
     * 2 parâmetro: valor min de dicas em cada sub-matriz.
     */
    MEDIUM(32, 3),
    /**
     * Dificuldade difícil.
     * 1 parâmetro: valor total de dicas.
     * 2 parâmetro: valor min de dicas em cada sub-matriz.
     */
    HARD(27, 2);

    /**
     * Valor máximo de dicas na aplicação.
     */
    private int totalTips;
    /**
     * Valor minímo de dicas em cada sub-matriz.
     */
    private int minGridTips;

    /**
     * Retorna o valor do máximo de dicas na aplicação.
     * @return int com o valor máximo de dicas na aplicação.
     */
    public int getTotalTips() {
        return totalTips;
    }

    /**
     * Retorna o valor minímo de dicas em cada sub-matriz.
     * @return int com o valor minímo de dicas em cada sub-matriz.
     */
    public int getMinGridTips() {
        return minGridTips;
    }

    /**
     * Construtor padrão.
     * @param totalTips valor máximo de dicas na aplicação.
     * @param minGridTips valor minímo de dicas em uma sub-matriz da aplicação.
     */
    private GameDifficulty(int totalTips, int minGridTips) {
        this.totalTips = totalTips;
        this.minGridTips = minGridTips;
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(hashCode()))
                .append(" { ")
                .append("\n        totalTips = " + totalTips)
                .append("\n        minGridTips = " + minGridTips)
                .append("\n    }");
        return objTxt.toString();
    }
}
