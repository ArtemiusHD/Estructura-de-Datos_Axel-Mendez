package Queue;
import Nodos.BooleanNodo;
public class PriorityBooleanQueue {
    private BooleanNodo front;
    private BooleanNodo rear;
    private Object[] queue;
    private int size;

    public PriorityBooleanQueue() {
        front=null;
        rear=null;
        size=0;


    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public void enqueue1(BooleanNodo nodo) {


        if(isEmpty()) {
            front=nodo;
            rear=nodo;
        }else {
            rear.setEnlace(nodo);
            rear=nodo;
        }


    }
    public void enqueue(Object value,Boolean prioridad) {
        BooleanNodo n=new BooleanNodo();
        n.setValor(value);
        n.setPrioridad(prioridad);
        if(isEmpty()) {
            front=n;
            rear=n;

        }else {
            if(!prioridad||rear.getPrioridad()) {
                enqueue1(n);
            }else {
                BooleanNodo actual=front;
                BooleanNodo siguiente=front.getEnlace();
                if(!front.getPrioridad()) {
                    n.setEnlace(front);
                    front=n;
                }else {
                    while(null!=siguiente) {
                        if(!siguiente.getPrioridad()) {
                            break;
                        }
                        actual=siguiente;
                        siguiente=siguiente.getEnlace();
                    }
                    actual.setEnlace(n);
                    n.setEnlace(siguiente);

                }

            }

        }
        size++;
    }

    public Object dequeue() {
        Object value=null;
        if(!isEmpty()) {
            size--;
            value=front.getValor();
            front=front.getEnlace();

        }
        return value;
    }

    public String toString() {
        String s="";
        BooleanNodo t=front;
        while(null!=t) {
            s+=t.getValor()+"<";
            t=t.getEnlace();
        }
        return s;
    }

}
