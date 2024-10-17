package Apuntes;
import java.util.PriorityQueue;
public class ColasDePrioridad {
    public static void main(String[] args) {
        //Estructura para declarar una cola de prioridad numerica
        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>();
        //Para añadir elementos se usa "add" y para eleminira "poll" o "remove"
        colaPrioridad.add(1);
        colaPrioridad.add(4);
        colaPrioridad.add(2);
        System.out.println(colaPrioridad);
        colaPrioridad.poll();
        System.out.println(colaPrioridad);
        //La prioridad de esta cola se comporta como un arbol
    }
}
