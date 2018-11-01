package br.univali.kob.model;

import java.util.Objects;

/** Representa uma célula.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public class Cell {
    /**
     * Valor da célula.
     */
    private int cell;
    /**
     * Indentifica se a célula esta travada para modificações ou não.
     */
    private final boolean isLocked;
    /**
     * Posição X da célula.
     */
    private int x;
    /**
     * Posição Y da célula.
     */
    private int y;

    /**
     * Construtor base da classe Cell.
     * @param cell valor da célula.
     * @param x posição X da célula.
     * @param y posição Y da célula.
     * @param isLocked se a célula está ou não travada para modifição.
     */
    public Cell (int cell, int x, int y,  boolean isLocked) {
        this.cell = cell;
        this.x = x;
        this.y = y;
        this.isLocked = isLocked;
    }

    public Cell (Cell cell) {
        this.cell = cell.cell;
        this.x = cell.x;
        this.y = cell.y;
        this.isLocked = cell.isLocked;
    }

    /**
     * Construtor da classe Cell.
     * @param cell valor da célula.
     * @param x posição X da célula.
     * @param y posição Y da célula.
     */
    public Cell (int cell, int x, int y) {
        this.cell = cell;
        this.x = x;
        this.y = y;
        this.isLocked = true;
    }

    /**
     * Retorna o valor da célula.
     * @return int com o valor da célula.
     */
    public int getCellValue() { return cell; }

    /**
     * Modifica o valor da célula, somente se isLocked for false.
     * @param cell nova valor que será atribuido a célula.
     */
    public void setCell(int cell) { if (!isLocked) this.cell = cell; }

    /**
     * Retorna o valor de X (posição da célula).
     * @return int com o valor de X (posição da célula).
     */
    public int getX() { return x; }

    /**
     * Retorna o valor de Y (posição da célula).
     * @return int com o valor de Y (posição da célula).
     */
    public int getY() { return y; }

    /**
     * Retorna se a célula está travada para modificações.
     * @return boolean com o valor que verifica se a célula está travada.
     */
    public boolean getIsLocked() { return isLocked; }

    @Override
    public boolean equals(Object obj) {
        if (this.equals(obj)) return true;
        if (!(obj instanceof Cell)) return false;
        Cell cell1 = (Cell) obj;
        return cell == cell1.cell &&
                isLocked == cell1.isLocked &&
                x == cell1.x &&
                y == cell1.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cell, isLocked, x, y);
    }

    @Override
    public String toString() {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(hashCode()))
                .append("{")
                .append("\n    cell = " + cell)
                .append(",\n    isLocked = " + isLocked)
                .append(",\n    x = " + x)
                .append(",\n    y = " + y)
                .append("\n}");
        return objTxt.toString();
    }
}
