package ExamenSegundoParcial;

import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;

public class EjercicioCinco {
    public static void main(String[] args) {
        Random random = new Random();
        Queue<Integer> cola = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            cola.add(random.nextInt(50) + 1);
        }
        System.out.println(cola);

    }
}
