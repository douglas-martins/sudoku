package br.univali.kob.model;

import br.univali.kob.model.matrix.Matrix;
import br.univali.kob.model.matrix.MatrixCell;
import br.univali.kob.model.matrix.MatrixPosition;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/** Representa as configurações da aplicação.
 * @author Douglas Martins
 * @author douglasfabiamartins@hotmail.com
 * @version 1.0
 * @since 1.0
 */
public class AppConfig {
    /**
     * Nome da aplicação.
     */
    public static final String APP_NAME;
    /**
     * Versão da aplicação.
     */
    public static final String APP_VERSION;
    /**
     * Matriz base do jogo.
     */
    public static final ArrayList<Matrix> BASE_MATRIX;
    /**
     * Número de células que um jogo possui.
     */
    public static final int SUDOKU_CELLS_NUMBER;

    /**
     * Constante com formato brasileiro de data.
     */
    public static final DateTimeFormatter DATE_FORMAT;

    /**
     * Lista se configurações da aplicação.
     */
    private static final ArrayList<Object> SETTINGS = new ArrayList<>();

    static {
        loadSettings();
        APP_NAME = (String)SETTINGS.get(0);
        APP_VERSION = (String)SETTINGS.get(1);
        BASE_MATRIX = (ArrayList<Matrix>)SETTINGS.get(2);
        SUDOKU_CELLS_NUMBER = (int)SETTINGS.get(3);
        DATE_FORMAT = (DateTimeFormatter)SETTINGS.get(4);
    }

    /**
     * Carrega as configurações de @SETTINGS e atribui os valores nos atributos.
     */
    private static void loadSettings() {
        SETTINGS.add("SUDOKU");
        SETTINGS.add("v 1.0");
        SETTINGS.add(generateBaseMatrix(new int[][]
                { { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                  { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
                  { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
                  { 2, 3, 4, 5, 6, 7, 8, 9, 1 },
                  { 5, 6, 7, 8, 9, 1, 2, 3, 4 },
                  { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
                  { 3, 4, 5, 6, 7, 8, 9, 1, 2 },
                  { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
                  { 9, 1, 2, 3, 4, 5, 6, 7, 8 }
                }));
        SETTINGS.add(81);
        SETTINGS.add(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Gera uma matriz base a partir de valores de uma matriz passado por parâmetro.
     * @param values matriz de int com os valores da matriz base.
     * @return retorna um ArrayList da classe Matrix, que representa a matriz base do jogo.
     */
    private static ArrayList<Matrix> generateBaseMatrix (int[][] values) {
        // checar tamanho da matriz (9x9)
        ArrayList<Matrix> matrices = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            matrices.add(i, smallBaseMatrix(MatrixPosition.values()[i], values[i]));
        }
        return matrices;
    }

    /**
     * Gera uma sub-matriz para ser inserida da matriz/grid da aplicação
     * @param position posição na matriz/grid da aplicação.
     * @param values valores da sub-matriz que será inseriada na magtriz/grid da aplicação.
     * @return uma Matrix, que serve como sub-matriz da aplicação
     */
    private static Matrix smallBaseMatrix (MatrixPosition position, int[] values) {
        ArrayList<ArrayList<MatrixCell>> matrix = new ArrayList<>();
        int jump = 0;
        for (int i = 0; i < 3; i++) {
            ArrayList<MatrixCell> holder = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                MatrixCell cell = new MatrixCell(values[j + jump], i, j, true);
                holder.add(cell);
            }
            matrix.add(i, holder);
            jump += 3;
        }
        return new Matrix(position, matrix);
    }
}
