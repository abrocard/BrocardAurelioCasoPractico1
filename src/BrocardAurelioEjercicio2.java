import java.util.Scanner;
public class BrocardAurelioEjercicio2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        final int dimensionTablero = 8; // Tamaño del tablero (8x8)
        final int minimoCasilla = 1;
        final int maximoCasilla = 15;

        char patron;
        int dimensionCasilla;
        /*
            Usuario introduce con que carácter se haran las casillas
         */
        System.out.println("Introduzca el carácter para el patron del tablero: ");
        patron = scanner.next().charAt(0);

        /*
            Usuario introduce las dimensiones de la casilla
         */

        while (true){
            System.out.println("Introduzca el tamaño de la casilla, ha de ser un valor entre 1 y 15:");
            if (scanner.hasNextInt()){
                dimensionCasilla= scanner.nextInt();
                if (dimensionCasilla>= minimoCasilla && dimensionCasilla<= maximoCasilla){
                    break;
                }else {
                    System.out.println("Entrada no valida");
                }
            }else {
                System.out.println("Entrada no valida");
                scanner.next();
            }
        }

        /*
            Generar el tablero de ajedrez
         */

        for (int fila=0; fila<dimensionTablero; fila++) {
            for (int x = 0; x < dimensionCasilla; x++) {
                for (int columna = 0; columna < dimensionTablero; columna++) {
                    boolean casillaNegra = (fila + columna) % 2==0;

                    for (int y = 0; y < dimensionCasilla; y++) {
                        System.out.print(casillaNegra ? patron : " ");
                    }
                }
                System.out.println();
            }
        }

    }
}
