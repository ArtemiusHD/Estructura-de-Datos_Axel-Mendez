package ExamenFinal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EjercicioTres {
    public static void main(String[] args) {
        String[] palabras = {"Menos", "Nabucodonosor", "Bebida", "Angelopolis", "Corleone", "Avion", "Planta", "Centro comercial", "Ana", "Cthulhu"};
        Queue<String> cola = new LinkedList<>();
        for (String palabra : palabras) {
            insertarConPrioridad(cola, palabra);
        }
        System.out.println("Palabras Ordenadas: ");
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }
    private static int contarVocales(String palabra) {
        int cuenta = 0;
        String vocales = "aeiouAEIOU";
        for (char c : palabra.toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                cuenta++;
            }
        }
        return cuenta;
    }
    private static void insertarConPrioridad(Queue<String> cola, String palabra) {
        int numVocales = contarVocales(palabra);
        ArrayList<String> temporal = new ArrayList<>();
        while (!cola.isEmpty() && contarVocales(cola.peek()) >= numVocales) {
            temporal.add(cola.poll());
        }
        cola.offer(palabra);
        cola.addAll(temporal);
    }
}

