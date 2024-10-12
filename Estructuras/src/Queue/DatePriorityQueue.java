package Queue;
import Nodos.DateNodo;
import java.util.Date;

public class DatePriorityQueue {
    private DateNodo front;
    private DateNodo rear;
    private int size;
    public DatePriorityQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void enqueue1(DateNodo nodo) {
        if (isEmpty()) {
            front = nodo;
            rear = nodo;
        } else {
            rear.setEnlace(nodo);
            rear = nodo;
        }
    }
    public void enqueue(Object value, Date fecha) {
        DateNodo  n = new DateNodo ();
        n.setValor(value);
        n.setFecha(fecha);
        if (isEmpty()) {
            front = n;
            rear = n;
        } else {
            if (fecha.after(rear.getFecha())) {
                enqueue1(n);
            } else {
                DateNodo  actual = front;
                DateNodo  siguiente = front.getEnlace();
                if (fecha.before(front.getFecha())) {
                    n.setEnlace(front);
                    front = n;
                } else {
                    while (siguiente != null) {
                        if (fecha.before(siguiente.getFecha())) {
                            break;
                        }
                        actual = siguiente;
                        siguiente = siguiente.getEnlace();
                    }
                    actual.setEnlace(n);
                    n.setEnlace(siguiente);
                }
            }
        }
        size++;
    }
    public Object dequeue() {
        Object value = null;
        if (!isEmpty()) {
            size--;
            value = front.getValor();
            front = front.getEnlace();
        }
        return value;
    }
    public String toString() {
        String s = "";
        DateNodo  t = front;
        while (t != null) {
            s += t.getValor() + "<";
            t = t.getEnlace();
        }
        return s;
    }
}