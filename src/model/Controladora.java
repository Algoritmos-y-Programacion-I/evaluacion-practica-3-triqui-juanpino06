package model;
import java.util.Random;

public class Controladora {
 
private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    public String[][] getTableroTresEnRaya() {
        return tableroTresEnRaya;
    }
}