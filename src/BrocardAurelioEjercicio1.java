import java.util.Random;
import java.util.Scanner;
public class BrocardAurelioEjercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        /*
        El usuario introducira un numero de columnas y luego un numero de filas
         */

        System.out.println("Introduzca un numero entero de columnas:");
        int columnas;
        while (true) {
            if (scanner.hasNextInt()) { //El numero de columnas sea un valor int
                columnas = scanner.nextInt();
                if (columnas > 0) { //El numero de columnas es un valor positivo
                    break;
                } else { //Volver a empezar el bucle si no es positivo
                    System.out.println("Porfavor, introduzca un numero valido de columnas:");
                }
            } else { //Volver a empezar el bucle si es otro valor diferente a int
                System.out.println("Porfavor, introduzca un numero valido de columnas:");
                scanner.next();
            }
        }
        System.out.println("Introduzca un numero entero de filas:");

        int filas;
        while (true) {
            if (scanner.hasNextInt()) {
                filas = scanner.nextInt();
                if (filas > 0) {
                    break;
                } else {
                    System.out.println("Porfavor, introduzca un numero valido de filas:");
                    scanner.next();
                }
            } else {
                System.out.println("Porfavor, introduzca un numero valido de filas:");
                scanner.next();
            }
        }

        /*
        Crear una matriz con las filas y columnnas que ha introducido el usuario
         */

        int[][] tablero = new int[filas][columnas];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++)
                tablero[i][j] = random.nextInt(9) + 1; //Crear un numero aleatorio del 0 al 8. Luego +1 para que sea entre el 1 y el 9
        }
        for (int[] ints : tablero) {
            for (int anInt : ints) {
                System.out.print(anInt + "   ");
            }
            System.out.println();
        }
        /*
        El usuario escoje entre 3 opciones distintas
         */
        while (true) {
            System.out.println("[2] Poner bomba");
            System.out.println("[1] Mostrar matriz");
            System.out.println("[0] Salir");
            int eleccion;
            if (scanner.hasNextInt()){
                eleccion= scanner.nextInt();
                if(eleccion == 0)  { // El programa se cierra
                    System.out.println("El programa se cerrará...");
                    System.exit(0);
                }
                if (eleccion == 1){ //El programa muestra la matriz
                    for (int[] ints : tablero) {
                        for (int anInt : ints) {
                            System.out.print(anInt + "   ");
                        }
                        System.out.println();
                    }
                }
                if (eleccion == 2) { // El programa continua y pide coordenadasd para poner una bomba
                    int bombaColumna;
                    int bombaFila;
                    while (true) {
                        System.out.println("Introduzca la coordenada X (número de columna del 1 al " + columnas + "):");
                        if (scanner.hasNextInt()) {
                            bombaColumna= scanner.nextInt();
                            if (bombaColumna > 0 && bombaColumna <= tablero[0].length) {
                                break;
                            } else {
                                System.out.println("Valor no válido");
                            }
                        }else {
                            System.out.println("Valor no valido");
                            scanner.next();
                        }
                    }
                    while (true) {
                        System.out.println("Introduzca la coordenada Y (número de fila del 1 al " + filas + "):");
                        if (scanner.hasNextInt()) {
                            bombaFila= scanner.nextInt();
                            if (bombaFila > 0 && bombaFila <= tablero.length) {
                                break;
                            } else {
                                System.out.println("Valor no válido");
                            }
                        }else {
                            System.out.println("Valor no válido");
                            scanner.next();
                        }
                    }
                    /*
                    Explosion de la bomba
                     */

                    for (int i=0;i<tablero.length;i++){
                        tablero[i][bombaFila-1]= 0;
                    }
                    for (int j = 0; j <tablero[0].length; j++){
                        tablero[bombaColumna-1][j]= 0;
                    }
                }
            } else { // Si se introduce un valor incorrecto, devuelve un mensaje y empieza el bucle de nuevo
                System.out.println("Esta opción no existe");
                scanner.next();
            }

        }
    }
}