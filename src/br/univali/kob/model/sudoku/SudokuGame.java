package br.univali.kob.model.sudoku;

import br.univali.kob.model.AppConfig;
import br.univali.kob.model.matrix.MatrixCell;
import br.univali.kob.model.helpers.Console;
import br.univali.kob.model.helpers.OutOfRangeException;
import br.univali.kob.model.helpers.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/** Representa o game e suas regras.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public class SudokuGame {
    /**
     * Representa as regras do jogo.
     */
    private SudokuGenerator sudokuGenerator;
    /**
     * Tempo de jogo decorrido.
     */
    private LocalDate gameTime;
    /**
     * Valor de tentativas válidas.
     */
    private int validAttempts;
    /**
     * Valor de tentativas inválidas.
     */
    private int invalidAttempts;

    /**
     * Construtor padrão.
     * @param gameDifficulty valor da dificuldade do game.
     */
    public SudokuGame(GameDifficulty gameDifficulty) {
        this.sudokuGenerator = new SudokuGenerator(gameDifficulty);
        this.gameTime = LocalDate.parse(LocalDate.now().format(AppConfig.DATE_FORMAT), AppConfig.DATE_FORMAT);
    }

    /**
     * Retorna o valor do jogo (que foi gerado).
     * @return SudokuGenerator com o valor do jogo.
     */
    public SudokuGenerator getSudoku() { return sudokuGenerator; }

    /**
     * Retorna o valor do tempo decorrido no jogo.
     * @return LocalDate com o tempo decorrido do jogo.
     */
    public LocalDate getGameTime() { return gameTime; }

    /**
     * Modifica o valor do tempo decorrido no jogo.
     * @param gameTime valor que sera atribuido ao tempo de jogo.
     */
    public void setGameTime(LocalDate gameTime) { this.gameTime = gameTime; }

    /**
     * Retorna o valor de tentativas validas.
     * @return int com o valor de tentativas validas.
     */
    public int getValidAttempts() { return validAttempts; }

    /**
     * Modifica o valor de tentativas validas.
     * @param validAttempts valor que sera atribuido a quantidade de tentativas validas.
     */
    public void setValidAttempts(int validAttempts) { this.validAttempts = validAttempts; }

    /**
     * Retorna o valor de tentativas invalidas.
     * @return int com o valor de tentativas invalidas.
     */
    public int getInvalidAttpempts() { return invalidAttempts; }

    /**
     * Modifica o valor de tentativas invalidas.
     * @param invalidAttempts valor que sera atribuidao a quantidade de tentativas invalidas
     */
    public void setInvalidAttpempts(int invalidAttempts) { this.invalidAttempts = invalidAttempts; }

    /**
     * Retorna se o game acabou ou não.
     * @return boolean true se o jogo acabou e false se não.
     */
    public boolean isGameOver() {
        return !Console.ask("Você deseja continua o jogo? (s/n)")
                || checkWinningCondition();
    }

    /**
     * Retorna a quantidade de tempo percorrido do inicio do jogo até o fim.
     * @return int com a quantidade de tempo decorrido.
     */
    public int gameElapsedTime() {
        return (int)Period.between(gameTime, LocalDate.now()).get(ChronoUnit.MINUTES);
    }

    /**
     * Verifica se a posição que sera adicionada na matriz, é válida ou não.
     * @param matrixCell MatrixCell com o valor da posição.
     * @return boolean true se válido, false se inválido.
     * @throws OutOfRangeException
     */
    public boolean isValidGameTablePosition(MatrixCell matrixCell) {
        Validator.notNull(matrixCell, matrixCell.getClass().getName());
        return matrixCell.getCell().getX() <= 9 || matrixCell.getCell().getX() < 1 &&
                matrixCell.getCell().getY() <= 9 || matrixCell.getCell().getY() < 1;
    }

    /**
     * Verifica se a célula que sera adicionada na matriz, é válida ou não.
     * @param matrixCell MatrixCell com o valor da célula.
     * @return boolean true se válido, false se inválido.
     * @throws OutOfRangeException
     */
    public boolean isValidGameTableCellValue(MatrixCell matrixCell) {
        Validator.notNull(matrixCell, matrixCell.getClass().getName());
        return matrixCell.getCell().getCellValue() <= 9 &&
                matrixCell.getCell().getCellValue() >= 0;
    }

    /**
     * Verifica se aquela célula na table do game, está isLocked ou não.
     * @param matrixCell MatrixCell com o valor de isLocked da célula.
     * @return boolean true se travado, false se destravado.
     */
    public boolean isValidGameTableCell (MatrixCell matrixCell) {
        Validator.notNull(matrixCell, matrixCell.getClass().getName());
        return matrixCell.getCell().getIsLocked();
    }

    /**
     * Retorna o valor do tempo atual no mundo.
     * @return LocalDate com o valor do tempo atual.
     */
    private LocalDate getTimeNow() {
        return LocalDate.parse(LocalDate.now().format(AppConfig.DATE_FORMAT), AppConfig.DATE_FORMAT);
    }

    /**
     *
     * @return
     */
    private boolean checkWinningCondition() {
        return sudokuGenerator.getTable().hashCode() == sudokuGenerator.getCorrectTable().hashCode();
    }
}
