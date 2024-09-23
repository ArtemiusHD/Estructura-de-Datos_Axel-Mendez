package MaquinaDeComida;
import Queue.CircularQueue;
public class Productos {
public CircularQueue[] productos;
private String[] nombresProductos = {
        "Coca Cola", "Fanta", "Squirt", "Boeing", "Pepsi", "Galletas", "Chocolate", "Fuze tea", "Papas", "Chetos"
};
private int[] costoProductos = {
       15, 14, 14, 13, 14, 12, 10, 15, 12, 12
};
private String[] clavesMaquina = {
  "A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4", "C1", "C2"
};
public Productos(){
    productos = new CircularQueue[10];
    for(int i = 0; i< productos.length; i++){
        productos[i] = new CircularQueue(10);
    }
}
public void rellenarStock (int indice, Object item){
    if(indice >=0 && indice < productos.length){
        while(!productos[indice].isFull()){
            productos[indice].enqueue(item);
        }
    }else {
        System.out.println("Indice del producto fuera de rango");
    }
}
public void rellenarTodo (Object item){
    for (int i = 0; i < productos.length; i++){
        rellenarStock(i , item);
    }
}
public void mostrarProductos (int indice){
    if(indice >=0 && indice < productos.length){
        System.out.println("Producto: " + nombresProductos[indice] +
                " | Costo:" + costoProductos[indice] +
                " | Clave: " + clavesMaquina[indice]);
        System.out.println("Stock: " + productos[indice].toString());
    }else{
        System.out.println("Indice de producto fuera de rango");
    }
}
public void mostrarTodosLosProductos(){
    for(int i = 0; i < productos.length; i++){
        mostrarProductos(i);
    }
}
public int obtenerCosto (String clave){
    for(int i = 0; i < clavesMaquina.length; i++){
        if(clavesMaquina[i].equals(clave)){
            return costoProductos[i];
        }
    }
    System.out.println("Producto no encontrado");
    return -1;
}
public boolean disponibilidadProducto (String clave){
    for(int i = 0; i < clavesMaquina.length; i++){
        if(clavesMaquina[i].equals(clave)){
            return !productos[i].isEmpty();
        }
    }
    System.out.println("Producto no encontrado");
    return false;
}
public Object venderProducto (String clave){
    for(int i = 0; i < clavesMaquina.length; i++){
        if(clavesMaquina[i].equals(clave)){
            return productos[i].dequeue();
        }
    }
    System.out.println("Producto no encontrado");
    return null;
}
}
