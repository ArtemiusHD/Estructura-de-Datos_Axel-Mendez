package ExamenSegundoParcial;

import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;
import java.util.ArrayList;

public class EjercicioTres {
    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            cola.add(random.nextInt(50) + 1);
        }
        System.out.println("Números en la cola: " + cola);
        int[] frecuencias = new int[51];
        for (int numero : cola) {
            frecuencias[numero]++;
        }
        for (int numero : cola) {
            if (frecuencias[numero] == 1) {
                lista.add(numero);
            }
        }
        System.out.println("Números en la lista: " + lista);
    }
}
