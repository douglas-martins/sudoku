package br.univali.kob.model;

/** Representa uma célula da matriz.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public class MatrixCell {
    /**
     * Representa a célula.
     */
    private Cell cell;

    /**
     * Construtor da classe.
     * @param cell valor da célula.
     * @param x valor da posição X da célula.
     * @param y valor da posição Y da célula.
     * @param isLocked valor para saber se célula está travada para alteração ou não.
     */
    public MatrixCell (int cell, int x, int y, boolean isLocked) { this.cell = new Cell(cell, x, y, isLocked); }

    /**
     * Construtor da classe.
     * @param cell valor da célula.
     * @param x valor da posição X da célula.
     * @param y valor da posição Y da célula.
     */
    public MatrixCell (int cell, int x, int y) { this.cell = new Cell(cell, x, y); }

    public MatrixCell(MatrixCell matrixCell) {
        this.cell = new Cell(matrixCell.cell);
    }

    /**
     * Retorna o valor da célula.
     * @return Cell valor da célula.
     */
    public Cell getCell() { return cell; }

    /**
     * Modifica o valor da célula.
     * @param cell novo valor da célula.
     */
    public void setCell(Cell cell) { this.cell = cell; }

    @Override
    public String toString () {
        StringBuilder objTxt = new StringBuilder();
        objTxt.append(this.getClass().getName())
                .append(" @ " + Integer.toHexString(this.getClass().hashCode()))
                .append("{")
                .append("\n    // Cell")
                .append(" @ " + Integer.toHexString(cell.getClass().hashCode()))
                .append(" { ")
                .append("\n        cell = " + cell.getCellValue())
                .append("\n        x = " + cell.getX())
                .append("\n        y = " + cell.getY())
                .append("\n        isLocked = " + cell.getIsLocked())
                .append("\n    }")
                .append("\n}");
        return objTxt.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        MatrixCell matrixCell =  (MatrixCell)obj;
        return getCell() == matrixCell.getCell() &&
                cell.getX() == matrixCell.cell.getX() &&
                cell.getY() == matrixCell.cell.getY() &&
                cell.getIsLocked() == matrixCell.cell.getIsLocked();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
