package Apuntes;
import java.util.LinkedList;
import java.util.Queue;
public class Colas {
    public static void main(String[] args) {
        //Estructura para declarar una cola, se utiliza LinkedList ya que la clase Queue es abstracta
        Queue<String> cola = new LinkedList<String>();
        //Para agregar elemento a la cola se usa "offer" o "add"
        cola.offer("a");
        cola.offer("b");
        cola.add("c");
        //Para mostrar el primer elemento de la cola se usa "peek"
        System.out.println(cola.peek());
        //Para remover un elemento de la cola se usa "remove"
        System.out.println(cola.remove());
        System.out.println(cola.peek());
    }
}
