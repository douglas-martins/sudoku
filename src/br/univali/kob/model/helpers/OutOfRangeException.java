package br.univali.kob.model.helpers;

/** Representa uma célula.
 * @author Marcello Thiry
 * @author marcello.thiry@gmail.com
 * @version 1.0
 * @since 1.0
 */
public class OutOfRangeException extends IllegalArgumentException {
    /**
     * Valor a ser avaliado que pode estar fora da faixa esperada.
     */
    private final int value;
    /**
     * Texto para descrever o valor.
     */
    private final String valueLabel;
    /**
     * Valor minimo permitido.
     */
    private final int min;
    /**
     * Valor maximo permitido.
     */
    private final int max;

    /**
     * Construtor padrão.
     * A mensagem é montada com rótulo passado no parâmetro.
     * @param value o valor avaliado que está fora da faixa esperada.
     * @param valueLabel o texto que descreve o valor.
     * @param min o valor minimo aceitável para a faixa.
     * @param max o valor maximo aceitável para a faixa.
     */
    public OutOfRangeException(int value, String valueLabel, int min, int max) {
        super("Value " + value + " for " + valueLabel
                + " is out of range [" + min + ".." + max + "]");
        this.value = value;
        this.valueLabel = valueLabel;
        this.min = min;
        this.max = max;
    }

    /**
     * Retorna o valor que é avaliado pela exceção.
     * @return int com o valor que é avaliado pela exceção.
     */
    public int getValue() { return value; }

    /**
     * Retorna o valor do texto que descreve o valor avaliado.
     * @return String com o texto que descreve o valor avaliado.
     */
    public String getValueLabel() { return valueLabel; }

    /**
     * Retorna o valor minimo que pode ser avaliado.
     * @return int com o valor minimo.
     */
    public int getMin() { return min; }

    /**
     * Retorna o valor maximo que pode ser avaliado.
     * @return int com o valor maximo.
     */
    public int getMax() { return max; }
}
