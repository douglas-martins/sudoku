package br.univali.kob.model.helpers;

/**
 * 
 */
public class Validator {
    /**
     * @param value 
     * @param valueLabel 
     * @return
     */
    public static void notNull(Object value, String valueLabel) {
        if (value == null) {
            throw new NullPointerException(valueLabel + " cannot be null!");
        }
    }
}