package MaquinaDeComida;

import Queue.CircularQueue;

public class Monedas {
    public CircularQueue[] monedas;
    private String[] tiposMonedas = {
      "10 pesos", "5 pesos", "2 pesos", "1 peso", "0.50 pesos"
    };
    public Monedas(){
        monedas = new CircularQueue[5];
        for (int i = 0; i < monedas.length; i++){
            monedas[i] = new CircularQueue(15);
        }
    }
    public void rellenarMonedas(int indice, Object item){
        if(indice >= 0 && indice < monedas.length){
            while(!monedas[indice].isFull()){
                monedas[indice].enqueue(item);
            }
        }else{
            System.out.println("Moneda fuera de rango");
        }
    }
    public void mostrarMonedas(){
        for(int i = 0; i < monedas.length; i++){
            System.out.println("Monedas de " + tiposMonedas[i] + ": " + monedas[i].toString());
        }
    }
    public int contarMonedas(){
        int total = 0;
        for(int i = 0; i < monedas.length; i++){
            total += monedas[i].getSize();
        }
        return total;
    }
}
