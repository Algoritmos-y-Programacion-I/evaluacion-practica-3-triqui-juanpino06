package ui;
import java.util.Scanner;
import model.Controladora;

public class Executable {
    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la maquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La maquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        int i, j;
        boolean validInput = false;
        do {
            System.out.println("Ingrese la fila (0-2):");
            if (reader.hasNextInt()) {
                i = reader.nextInt();
                if (i >= 0 && i < 3) {
                    System.out.println("Ingrese la columna entre (0-2):");
                    if (reader.hasNextInt()) {
                        j = reader.nextInt();
                        if (j >= 0 && j < 3) {
                            if (cont.getTableroTresEnRaya()[i][j].equals(" ")) {
                                cont.getTableroTresEnRaya()[i][j] = "O"; 
                                validInput = true;
                                imprimirTablero();
                            } else {
                                System.out.println("La casilla ya está ocupada. Intenta de nuevo.");
                            }
                        } else {
                            System.out.println("La columna ingresada es invalida. Intenta de nuevo.");
                            reader.next();
                        }
                    } else {
                        System.out.println("Entrada invalida. Intenta de nuevo.");
                        reader.next();
                    }
                } else {
                    System.out.println("La fila que se ingreso es invalida. Intenta de nuevo.");
                    reader.next();
                }
            } else {
                System.out.println("Entrada invalida. Intente de nuevo.");
                reader.next();
            }
        } while (!validInput);
    }

    private void validarGanador() {
        String ganador = null;
    
        for (int i = 0; i < 3; i++) {
            if (cont.getTableroTresEnRaya()[i][0].equals(cont.getTableroTresEnRaya()[i][1]) && cont.getTableroTresEnRaya()[i][1].equals(cont.getTableroTresEnRaya()[i][2]) && !cont.getTableroTresEnRaya()[i][0].equals(" ")) {
                ganador = cont.getTableroTresEnRaya()[i][0];
                break;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (cont.getTableroTresEnRaya()[0][j].equals(cont.getTableroTresEnRaya()[1][j]) && cont.getTableroTresEnRaya()[1][j].equals(cont.getTableroTresEnRaya()[2][j]) && !cont.getTableroTresEnRaya()[0][j].equals(" ")) {
                ganador = cont.getTableroTresEnRaya()[0][j];
                break;
            }
        }
    
        if (cont.getTableroTresEnRaya()[0][0].equals(cont.getTableroTresEnRaya()[1][1]) && cont.getTableroTresEnRaya()[1][1].equals(cont.getTableroTresEnRaya()[2][2]) && !cont.getTableroTresEnRaya()[0][0].equals(" ")) {
            ganador = cont.getTableroTresEnRaya()[0][0];

        } else if (cont.getTableroTresEnRaya()[0][2].equals(cont.getTableroTresEnRaya()[1][1]) && cont.getTableroTresEnRaya()[1][1].equals(cont.getTableroTresEnRaya()[2][0]) && !cont.getTableroTresEnRaya()[0][2].equals(" ")) {
            ganador = cont.getTableroTresEnRaya()[0][2];
        }
    
        if (ganador != null) {
            if (ganador.equals("X")) {
                System.out.println("La maquina ha ganado el juego.");
            } else {
                System.out.println("El jugador ha ganado el juego.");
            }
        } else {
            System.out.println("No hay un ganador en el momento.");
        }
    }
}
    