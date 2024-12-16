package ExamenFinal;

import java.util.Scanner;
import java.util.Stack;

public class EjercicioDos {
    private static Stack<String> texto;
    private static Stack<String> palabrasBorradas;
    public static void main(String[] args) {
        texto = new Stack<>();
        palabrasBorradas = new Stack<>();
        Scanner leer = new Scanner(System.in);
        int opcionMenu = 0;
        String palabra;
        do {
            System.out.println("Documento actual: " + String.join(" ", texto));
            System.out.println("""
                    Para agregar una palabra presione: 1
                    Para quitar una palabra presione: 2
                    Para reagregar una palabra presione: 3
                    Para salir del programa presione: 4""");
            opcionMenu = leer.nextInt();
            leer.nextLine();
            switch (opcionMenu) {
                case 1:
                    System.out.print("Ingrese la palabra a agregar: ");
                    palabra = leer.nextLine();
                    agregarPalabra(palabra);
                    break;
                case 2:
                    deshacer();
                    break;
                case 3:
                    rehacer();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcionMenu != 4);
    }

    private static void agregarPalabra(String palabra) {
        texto.push(palabra);
        palabrasBorradas.clear();
        System.out.println("Palabra '" + palabra + "' agregada.");
    }

    private static void deshacer() {
        if (!texto.isEmpty()) {
            String palabra = texto.pop();
            palabrasBorradas.push(palabra);
            System.out.println("Palabra '" + palabra + "' removida.");
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    private static void rehacer() {
        if (!palabrasBorradas.isEmpty()) {
            String palabra = palabrasBorradas.pop();
            texto.push(palabra);
            System.out.println("Palabra '" + palabra + "' agregada nuevamente.");
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }
}


