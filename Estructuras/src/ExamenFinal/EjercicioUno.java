package ExamenFinal;

import Queue.NumericPriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class EjercicioUno {
    private static NumericPriorityQueue cola = new NumericPriorityQueue();
    private static final Random random = new Random();
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcionMenu = 0;
        do {
            System.out.println("""
                    Para generar la clave de un libro presione: 1
                    Para mostrar las claves de los libros presione: 2
                    Para cerrar el programa presione: 3""");
            opcionMenu = leer.nextInt();
            leer.nextLine();
            switch (opcionMenu) {
                case 1:
                    generarClave();
                    break;
                case 2:
                    mostrarClaves();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        } while (opcionMenu != 3);
    }

    private static void generarClave() {
        int año = random.nextInt(2007 - 1990 + 1) + 1990;
        String numeroLibro = String.format("%04d", random.nextInt(10000));
        String isbn = "ISBN-" + año + "-" + numeroLibro;
        cola.enqueue(isbn, año);
        System.out.println("La clave generada es: " + isbn);
    }
    private static void mostrarClaves() {
        System.out.println("Claves de los libros ordenados:");
        while (!cola.isEmpty()) {
            System.out.println(cola.dequeue());
        }
    }
}
