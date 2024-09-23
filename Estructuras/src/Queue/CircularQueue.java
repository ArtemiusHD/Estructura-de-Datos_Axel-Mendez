package Queue;

public class CircularQueue {
    private int f;
    private int r;
    private int size;
    private Object[] queue;
    public CircularQueue(int size){
        f = 0;
        r = 0;
        queue = new Object[size];
        this.size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public Boolean isFull(){
        return size == queue.length;
    }
    public void enqueue (Object value){
        if(!isFull()){
            queue[f] = value;
            f++;
            size++;
            if(f==queue.length){
                f=0;
            }
        }
    }
    public Object dequeue (){
        Object value = null;
        if(!isEmpty()){
            value = queue[r];
            queue[r] = null;
            r++;
            size--;
            if(r== queue.length){
                r=0;
            }
        }
        return value;
    }
    public Object front(){
        Object value = null;
        if(!isEmpty()){
            int tempF = f -1;
            tempF = tempF==-1? queue.length-1 : tempF;
            value = queue[tempF];
        }
        return value;
    }
    public Object roar(){
        return queue[r];
    }
    public String toString(){
       String s = " ";
    for(int i = 0; i<size; i++){
        int tempI = i+f;
        tempI = tempI == queue.length-1?0:tempI;
        s+=queue[tempI]+">";
    }
    return s;
    }
    public int getSize(){
        return size;
    }
}
